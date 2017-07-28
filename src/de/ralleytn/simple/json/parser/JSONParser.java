/*
 * $Id: JSONParser.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-15
 */
package de.ralleytn.simple.json.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import de.ralleytn.simple.json.JSONArray;
import de.ralleytn.simple.json.JSONObject;


/**
 * Parser for JSON text. Please note that JSONParser is NOT thread-safe.
 * @author FangYidong<fangyidong@yahoo.com.cn>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JSONParser {
	
	private static final int S_INIT = 0;
	private static final int S_IN_FINISHED_VALUE = 1;
	private static final int S_IN_OBJECT = 2;
	private static final int S_IN_ARRAY = 3;
	private static final int S_PASSED_PAIR_KEY = 4;
	private static final int S_IN_PAIR_VALUE = 5;
	private static final int S_END = 6;
	private static final int S_IN_ERROR = -1;
	
	private LinkedList<Object> handlerStatusStack;
	private Yylex lexer = new Yylex((Reader)null);
	private Yytoken token = null;
	private int status = S_INIT;
	
	private int peekStatus(LinkedList<?> statusStack) {
		
		if(statusStack.size() != 0) {
			
			return (Integer)statusStack.getFirst();
		}
		
		return -1;
	}
	
    /**
     * Reset the parser to the initial state without resetting the underlying reader.
     * @since 1.0.0
     */
    public void reset(){
    	
        this.token = null;
        this.status = JSONParser.S_INIT;
        this.handlerStatusStack = null;
    }
    
    /**
     * Reset the parser to the initial state with a new character reader.
     * 
     * @param in - The new character reader.
     * @throws IOException
     * @throws ParseException
     * @since 1.0.0
     */
	public void reset(Reader in) {
		
		this.lexer.yyreset(in);
		this.reset();
	}
	
	/**
	 * @return The position of the beginning of the current token.
	 */
	public int getPosition() {
		
		return this.lexer.getPosition();
	}
	
	public Object parse(String string) throws ParseException {
		
		return parse(string, (ContainerFactory)null);
	}
	
	public Object parse(String string, ContainerFactory containerFactory) throws ParseException {
		
		try(StringReader in = new StringReader(string)) {
			
			return this.parse(in, containerFactory);
		
		} catch(IOException exception){

			throw new ParseException(-1, ParseException.ERROR_UNEXPECTED_EXCEPTION, exception);
		}
	}
	
	public Object parse(Reader in) throws IOException, ParseException {
		
		return this.parse(in, (ContainerFactory)null);
	}
	
	/**
	 * Parse JSON text into java object from the input source.
	 * 	
	 * @param reader
     * @param containerFactory - Use this factory to createyour own JSON object and JSON array containers.
	 * @return Instance of the following:
	 *  org.json.simple.JSONObject,
	 * 	org.json.simple.JSONArray,
	 * 	java.lang.String,
	 * 	java.lang.Number,
	 * 	java.lang.Boolean,
	 * 	null
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public Object parse(Reader reader, ContainerFactory containerFactory) throws IOException, ParseException {
		
		this.reset(reader);
		Stack<Object> statusStack = new Stack<>();
		Stack<Object> valueStack = new Stack<>();
		
		try {
			
			do {
				
				this.nextToken();
				
				if(this.status == JSONParser.S_INIT) {
					
					if(this.token.type == Yytoken.TYPE_VALUE) {
						
						this.status = JSONParser.S_IN_FINISHED_VALUE;
						statusStack.push(new Integer(this.status));
						valueStack.push(this.token.value);
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_BRACE) {
						
						this.status = JSONParser.S_IN_OBJECT;
						statusStack.push(new Integer(this.status));
						valueStack.push(this.createObjectContainer(containerFactory));
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_SQUARE) {
						
						this.status = JSONParser.S_IN_ARRAY;
						statusStack.push(new Integer(this.status));
						valueStack.push(this.createArrayContainer(containerFactory));
						
					} else {
						
						this.status = JSONParser.S_IN_ERROR;
					}
					
				} else if(this.status == JSONParser.S_IN_FINISHED_VALUE) {
					
					if(this.token.type == Yytoken.TYPE_EOF) {
						
						return valueStack.pop();
						
					} else {
						
						throw new ParseException(this.getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, this.token);
					}
					
				} else if(this.status == JSONParser.S_IN_OBJECT) {
					
					if(this.token.type == Yytoken.TYPE_VALUE) {
						
						if(this.token.value instanceof String) {
							
							String key = (String)this.token.value;
							valueStack.push(key);
							this.status = JSONParser.S_PASSED_PAIR_KEY;
							statusStack.push(new Integer(this.status));
							
						} else {
							
							this.status = S_IN_ERROR;
						}
						
					} else if(this.token.type == Yytoken.TYPE_RIGHT_BRACE) {
						
						if(valueStack.size() > 1){
							
							statusStack.pop();
							valueStack.pop();
							this.status = (int)statusStack.peek();
							
						} else {
							
							this.status = JSONParser.S_IN_FINISHED_VALUE;
						}
						
					} else if(this.token.type != Yytoken.TYPE_COMMA) {
						
						this.status = JSONParser.S_IN_ERROR;
					}
					
				} else if(this.status == JSONParser.S_PASSED_PAIR_KEY) {
					
					if(this.token.type == Yytoken.TYPE_VALUE) {
						
						statusStack.pop();
						String key = (String)valueStack.pop();
						Map<Object, Object> parent = (Map<Object, Object>)valueStack.peek();
						parent.put(key, this.token.value);
						this.status = (int)statusStack.peek();
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_SQUARE) {
						
						statusStack.pop();
						String key = (String)valueStack.pop();
						Map<Object, Object> parent = (Map<Object, Object>)valueStack.peek();
						List<Object> newArray = (List<Object>)createArrayContainer(containerFactory);
						parent.put(key, newArray);
						this.status = JSONParser.S_IN_ARRAY;
						statusStack.push(new Integer(this.status));
						valueStack.push(newArray);
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_BRACE) {
						
						statusStack.pop();
						String key = (String)valueStack.pop();
						Map<Object, Object> parent = (Map<Object, Object>)valueStack.peek();
						Map<Object, Object> newObject = (Map<Object, Object>)createObjectContainer(containerFactory);
						parent.put(key, newObject);
						this.status = JSONParser.S_IN_OBJECT;
						statusStack.push(new Integer(this.status));
						valueStack.push(newObject);
						
					} else if(this.token.type != Yytoken.TYPE_COLON) {
						
						this.status = JSONParser.S_IN_ERROR;
					}
					
				} else if(this.status == JSONParser.S_IN_ARRAY) {
					
					if(this.token.type == Yytoken.TYPE_VALUE) {
						
						List<Object> val = (List<Object>)valueStack.peek();
						val.add(this.token.value);
						
					} else if(this.token.type == Yytoken.TYPE_RIGHT_SQUARE) {
						
						if(valueStack.size() > 1) {
							
							statusStack.pop();
							valueStack.pop();
							this.status = (int)statusStack.peek();
						
						} else {
							
							this.status = JSONParser.S_IN_FINISHED_VALUE;
						}
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_BRACE) {
						
						List<Object> val = (List<Object>)valueStack.peek();
						Map<Object, Object> newObject = this.createObjectContainer(containerFactory);
						val.add(newObject);
						this.status = JSONParser.S_IN_OBJECT;
						statusStack.push(new Integer(this.status));
						valueStack.push(newObject);
						
					} else if(this.token.type == Yytoken.TYPE_LEFT_SQUARE) {
						
						List<Object> val=(List<Object>)valueStack.peek();
						List<Object> newArray = this.createArrayContainer(containerFactory);
						val.add(newArray);
						this.status = JSONParser.S_IN_ARRAY;
						statusStack.push(new Integer(this.status));
						valueStack.push(newArray);
						
					} else if(this.token.type != Yytoken.TYPE_COMMA) {
						
						this.status = JSONParser.S_IN_ERROR;
					}
				}
				
				if(this.status == JSONParser.S_IN_ERROR) {
					
					throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, token);
				}

			} while(this.token.type != Yytoken.TYPE_EOF);
		
		} catch(IOException exception){
			
			throw exception;
		}
		
		throw new ParseException(this.getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, this.token);
	}
	
	private void nextToken() throws ParseException, IOException {
		
		this.token = this.lexer.yylex();
		
		if(this.token == null) {
			
			this.token = new Yytoken(Yytoken.TYPE_EOF, null);
		}
	}
	
	private Map<Object, Object> createObjectContainer(ContainerFactory containerFactory){
		if(containerFactory == null)
			return new JSONObject();
		Map<Object, Object> m = containerFactory.createObjectContainer();
		
		if(m == null)
			return new JSONObject();
		return m;
	}
	
	private List<Object> createArrayContainer(ContainerFactory containerFactory){
		if(containerFactory == null)
			return new JSONArray();
		List<Object> l = containerFactory.creatArrayContainer();
		
		if(l == null)
			return new JSONArray();
		return l;
	}
	
	public void parse(String s, ContentHandler contentHandler) throws ParseException{
		parse(s, contentHandler, false);
	}
	
	public void parse(String s, ContentHandler contentHandler, boolean isResume) throws ParseException{
		StringReader in=new StringReader(s);
		try{
			parse(in, contentHandler, isResume);
		}
		catch(IOException ie){
			/*
			 * Actually it will never happen.
			 */
			throw new ParseException(-1, ParseException.ERROR_UNEXPECTED_EXCEPTION, ie);
		}
	}
	
	public void parse(Reader in, ContentHandler contentHandler) throws IOException, ParseException{
		parse(in, contentHandler, false);
	}
	
	/**
	 * Stream processing of JSON text.
	 * 
	 * @see ContentHandler
	 * 
	 * @param in
	 * @param contentHandler
	 * @param isResume - Indicates if it continues previous parsing operation.
     *                   If set to true, resume parsing the old stream, and parameter 'in' will be ignored. 
	 *                   If this method is called for the first time in this instance, isResume will be ignored.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	public void parse(Reader in, ContentHandler contentHandler, boolean isResume) throws IOException, ParseException{
		if(!isResume){
			reset(in);
			handlerStatusStack = new LinkedList<>();
		}
		else{
			if(handlerStatusStack == null){
				isResume = false;
				reset(in);
				handlerStatusStack = new LinkedList<>();
			}
		}
		
		LinkedList<Object> statusStack = handlerStatusStack;	
		
		try{
			do{
				switch(status){
				case S_INIT:
					contentHandler.startJSON();
					nextToken();
					switch(token.type){
					case Yytoken.TYPE_VALUE:
						status=S_IN_FINISHED_VALUE;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.primitive(token.value))
							return;
						break;
					case Yytoken.TYPE_LEFT_BRACE:
						status=S_IN_OBJECT;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startObject())
							return;
						break;
					case Yytoken.TYPE_LEFT_SQUARE:
						status=S_IN_ARRAY;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startArray())
							return;
						break;
					default:
						status=S_IN_ERROR;
					}//inner switch
					break;
					
				case S_IN_FINISHED_VALUE:
					nextToken();
					if(token.type==Yytoken.TYPE_EOF){
						contentHandler.endJSON();
						status = S_END;
						return;
					}
					else{
						status = S_IN_ERROR;
						throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, token);
					}
			
				case S_IN_OBJECT:
					nextToken();
					switch(token.type){
					case Yytoken.TYPE_COMMA:
						break;
					case Yytoken.TYPE_VALUE:
						if(token.value instanceof String){
							String key=(String)token.value;
							status=S_PASSED_PAIR_KEY;
							statusStack.addFirst(new Integer(status));
							if(!contentHandler.startObjectEntry(key))
								return;
						}
						else{
							status=S_IN_ERROR;
						}
						break;
					case Yytoken.TYPE_RIGHT_BRACE:
						if(statusStack.size()>1){
							statusStack.removeFirst();
							status=peekStatus(statusStack);
						}
						else{
							status=S_IN_FINISHED_VALUE;
						}
						if(!contentHandler.endObject())
							return;
						break;
					default:
						status=S_IN_ERROR;
						break;
					}//inner switch
					break;
					
				case S_PASSED_PAIR_KEY:
					nextToken();
					switch(token.type){
					case Yytoken.TYPE_COLON:
						break;
					case Yytoken.TYPE_VALUE:
						statusStack.removeFirst();
						status=peekStatus(statusStack);
						if(!contentHandler.primitive(token.value))
							return;
						if(!contentHandler.endObjectEntry())
							return;
						break;
					case Yytoken.TYPE_LEFT_SQUARE:
						statusStack.removeFirst();
						statusStack.addFirst(new Integer(S_IN_PAIR_VALUE));
						status=S_IN_ARRAY;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startArray())
							return;
						break;
					case Yytoken.TYPE_LEFT_BRACE:
						statusStack.removeFirst();
						statusStack.addFirst(new Integer(S_IN_PAIR_VALUE));
						status=S_IN_OBJECT;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startObject())
							return;
						break;
					default:
						status=S_IN_ERROR;
					}
					break;
				
				case S_IN_PAIR_VALUE:
					/*
					 * S_IN_PAIR_VALUE is just a marker to indicate the end of an object entry, it doesn't proccess any token,
					 * therefore delay consuming token until next round.
					 */
					statusStack.removeFirst();
					status = peekStatus(statusStack);
					if(!contentHandler.endObjectEntry())
						return;
					break;
					
				case S_IN_ARRAY:
					nextToken();
					switch(token.type){
					case Yytoken.TYPE_COMMA:
						break;
					case Yytoken.TYPE_VALUE:
						if(!contentHandler.primitive(token.value))
							return;
						break;
					case Yytoken.TYPE_RIGHT_SQUARE:
						if(statusStack.size()>1){
							statusStack.removeFirst();
							status=peekStatus(statusStack);
						}
						else{
							status=S_IN_FINISHED_VALUE;
						}
						if(!contentHandler.endArray())
							return;
						break;
					case Yytoken.TYPE_LEFT_BRACE:
						status=S_IN_OBJECT;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startObject())
							return;
						break;
					case Yytoken.TYPE_LEFT_SQUARE:
						status=S_IN_ARRAY;
						statusStack.addFirst(new Integer(status));
						if(!contentHandler.startArray())
							return;
						break;
					default:
						status=S_IN_ERROR;
					}//inner switch
					break;
					
				case S_END:
					return;
					
				case S_IN_ERROR:
					throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, token);
				}//switch
				if(status==S_IN_ERROR){
					throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, token);
				}
			}while(token.type!=Yytoken.TYPE_EOF);
		}
		catch(IOException ie){
			status = S_IN_ERROR;
			throw ie;
		}
		catch(ParseException pe){
			status = S_IN_ERROR;
			throw pe;
		}
		catch(RuntimeException re){
			status = S_IN_ERROR;
			throw re;
		}
		catch(Error e){
			status = S_IN_ERROR;
			throw e;
		}
		
		status = S_IN_ERROR;
		throw new ParseException(getPosition(), ParseException.ERROR_UNEXPECTED_TOKEN, token);
	}
}

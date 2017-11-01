package Lab3;

/*
 *  @author Ireedui
 * 	Version 1.0
 * */

public class StateMachine {
		private boolean state1;
		private boolean state2;
		private boolean state3;

		public boolean isState1() {
			return state1;
		}
		public void setState1(boolean state1) {
			this.state1 = state1;
		}
		public boolean isState2() {
			return state2;
		}
		public void setState2(boolean state2) {
			this.state2 = state2;
		}
		public boolean isState3() {
			return state3;
		}
		public void setState3(boolean state3) {
			this.state3 = state3;
		}
		public StateMachine() {
			state1 = true;
			state2 = false;
			state3 = false;
		}
		public void process(String s) {
			
		    int length = s.length();
		    int whereState = 1;
		    for(int i = 0; i<length; i++) {
		    	
		    	String st2 = s.substring(i,i+1);
		   
		    			if(st2.indexOf("0") >= 0 || st2.indexOf("1") >= 0) {
		    						if(st2.indexOf("0") >= 0) {
		    								if(whereState == 1) {
		    									setState1(false);
		    									setState2(false);
		    									setState3(true);
		    									whereState = 3;
		    								}
		    								else if(whereState == 2) {
		    									setState1(false);
		    									setState2(true);
		    									setState3(false);
		    									whereState = 2;
		    								}
		    								else if(whereState == 3) {
		    									setState1(false);
		    									setState2(true);
		    									setState3(false);
		    									whereState = 2;
		    								}
		    						}
		    						else{
		    							if(whereState == 1) {
	    									setState1(false);
	    									setState2(true);
	    									setState3(false);
	    									whereState = 2;
	    								}
	    								else if(whereState == 2) {
	    									setState1(true);
	    									setState2(false);
	    									setState3(false);
	    									whereState = 1;
	    								}
	    								else if(whereState == 3) {
	    									setState1(false);
	    									setState2(false);
	    									setState3(true);
	    									whereState = 3;
	    								}
		    						}
		    					
		    			}
		    			else {
		    				break;
		    			}
		    }
			
		}
		public void printState() {
			System.out.print("The current state of machine is:");
			if(isState1()) {
				System.out.println("S1");
			}
			if(isState2()) {
				System.out.println("S2");
			}
			if(isState3()) {
				System.out.println("S3");
			}
		}
		
	public static void main(String[] args) {
			StateMachine a = new StateMachine();

			a.process("1001010101");
			a.printState();//s3
			
			StateMachine b = new StateMachine();
			b.process("01");
			b.printState();//s3
			
			a.process("0101a1");
			a.printState();//s1
	}

}

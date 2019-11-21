import processing.core.PApplet;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           EscapeRoom
// Files:           EscapeRoom.java, Action.java, Thing.java, VisibleThing.java, ClickableThing.java, DraggableThing.java, DragAndDroppableThing.java
// Course:          CS300, Fall 2019
//
// Author:          Yeochan Youn
// Email:           yyoun5@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


public class Thing {
	private final String NAME; // the constant name identifying this object
	private boolean isActive; // active means thing is visible and can be interacted with
	private static PApplet processing = null;
	
	public static void setProcessing(PApplet processing) {   
		Thing.processing = processing;
	} // initializes processing field
	
	protected static PApplet getProcessing() {
		return processing;
	} // accessor method to retrieve this static field
	
	public Thing(String name) {
		NAME = name;
		isActive = true;
	} // initialize name, and set isActive to true
	
	public boolean hasName(String name) {
		if(name.equals(NAME)) { // if name matches, true. false otherwise
			return true;
		}
		return false;
	} // returns true only when contents of name equal NAME
	
	public boolean isActive() {
		if(isActive) { // true if active, false otherwise
			return true;
		}
		return false;
	} // returns true only when isActive is true
	
	public void activate() {
		isActive = true;
	} // changes isActive to true
	
	public void deactivate() {
		isActive = false;
	} // changes isActive to false
	
	public Action update() { return null; } // this method returns null
	// subclass types will override this update() method to do more interesting things
}

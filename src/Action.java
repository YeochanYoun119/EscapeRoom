import java.util.ArrayList;

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


public class Action {
	private String message; // message printed by this action (or null to do nothing)
	private Thing thing;

	public Action(Thing thing) {
		this.thing = thing;
	}
	
	public Action(String message, Thing thing) {
		this.message = message;
		this.thing = thing;
	}

	public Action(String message) {
		this.message = message;
	} // initialize this new action

	/*
	 * do the action on specific thing 
	 */
	public void act(ArrayList<Thing> allThing) {
		if (!(this.message.equals(null))) {
			if (this.thing != null) {
				this.thing.activate();
				allThing.add(this.thing);
				this.thing = null;
			}
			System.out.println(this.message);
		}

	} // when message is not null, message is printed to System.out
}

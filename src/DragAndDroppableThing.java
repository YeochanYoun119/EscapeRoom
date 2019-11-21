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
public class DragAndDroppableThing extends DraggableThing{
	private VisibleThing target; // object over which this object can be dropped
	private Action action; // action that results from dropping this object over target

	public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
		super(name, x, y);
		this.target = target;
		this.action = action;
	} // initialize new object

	@Override
	protected Action drop() {
		if (target.isOver(this) && target.isActive()) { // if target is over this, deactivate both objects
			target.deactivate();
			this.deactivate();
			return action;
		} else {
			return null;
		}
	} // returns action and deactivates objects in response to successful drop
		// When this object is over its target and its target is active:
	// deactivate both this object and the target object, and return action,
	// otherwise return null
}

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
public class ClickableThing extends VisibleThing{

	private Action action; // action returned from update when this object is clicked
	private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

	public ClickableThing(String name, int x, int y, Action action) {
		super(name, x, y);
		mouseWasPressed = false;
		this.action = action;
	} // initializes this new object

	@Override
	public Action update() {
		super.update();
		int mouseX = getProcessing().mouseX;
		int mouseY = getProcessing().mouseY;

		if(getProcessing().mousePressed == true) {	
			if(mouseWasPressed == false && isOver(mouseX, mouseY)) {
				mouseWasPressed = true;
				return action;
			}
		}
		return null;
	} // calls VisibleThing update, then returns action only when mouse is first
		// clicked
}

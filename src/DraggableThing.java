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
public class DraggableThing extends VisibleThing{
	private boolean mouseWasPressed; // similar to use in ClickableThing
	private boolean isDragging; // true when this object is being dragged by the user
	private int oldMouseX; // horizontal position of mouse during last update
	private int oldMouseY; // vertical position of mouse during last update

	public DraggableThing(String name, int x, int y) {
		super(name, x, y);
		this.mouseWasPressed = false;
		this.isDragging = false;
		this.oldMouseX = 0;
		this.oldMouseY = 0;

	} // initialize new thing
	@Override
	public Action update() {
		super.update();
		Action action = null;
		if(getProcessing().mousePressed && this.isOver(getProcessing().mouseX, getProcessing().mouseY) && mouseWasPressed == false) {
			isDragging = true;
			oldMouseX = getProcessing().mouseX;
			oldMouseY = getProcessing().mouseY;
		}else if(getProcessing().mousePressed == false && mouseWasPressed == true) { 
            isDragging = false;
            action = drop();
        }
		 if(isDragging == true) {
	            int dx = getProcessing().mouseX - this.oldMouseX;
	            int dy = getProcessing().mouseY - this.oldMouseY;
	            this.move(dx, dy);
	            oldMouseX = getProcessing().mouseX;
	            oldMouseY = getProcessing().mouseY;
	        }
		 mouseWasPressed = getProcessing().mousePressed;
		 return action;
	} // calls VisibleThing update(), then moves according to mouse drag
	// each time isDragging changes from true to false, the drop() method below will be called once
	// and any action objects returned from that method should then be returned from update()
	protected Action drop() { return null; } // this method returns null
	// subclass types will override this drop() method to do more interesting things
}

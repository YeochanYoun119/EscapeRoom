import java.io.File;

import processing.core.PImage;

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
public class VisibleThing extends Thing{

	private PImage image; // the graphical representation of this thing
	private int x; // the horizontal position (in pixels of this thing's left side)
	private int y; // the vertical position (in pixels of this thing's top side)
	  
	public VisibleThing(String name, int x, int y) {
		super(name);
		String file = "images"+File.separator+ name +".png";
		image = super.getProcessing().loadImage(file);
		this.x = x;
		this.y = y;
	} // initialize this new thing
	// the image for this visible thing should be loaded from :
	// "images"+File.separator+ name +".png"
	@Override
	public Action update() {
		Thing.getProcessing().image(this.image, this.x, this.y);	
		return null;
	} // draws image at its position before returning null
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	} // changes x by adding dx to it (and y by dy)
	
	public boolean isOver(int x, int y) {
		 if(this.x + this.image.width >= x && this.x <= x && this.y + this.image.height >= y && this.y <= y) { // consider 4 corners of the object
	            return true;
	        }else {
	            return false;
	        }
	} // return true only when point x,y is over image
	
	public boolean isOver(VisibleThing other) {
		   if (this.y + this.image.height >= other.y && this.y <= other.y
		            && this.x + this.image.width >= other.x && this.x <= other.x) { // comparing 4 corner of two objects
		            return true;
		        } else {
		            return false;
		        }
		    } 
}

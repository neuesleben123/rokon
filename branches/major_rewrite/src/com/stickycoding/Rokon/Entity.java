package com.stickycoding.Rokon;

import javax.microedition.khronos.opengles.GL10;

import android.view.MotionEvent;

public class Entity {
	
	private boolean _dead;
	
	private int _x, _y, _width, _height;
	private int _velX, _velY, _accX, _accY;
	private int _rotationAngle, _rotationPivotX, _rotationPivotY;
	private boolean _rotateAboutCentre = true;
	private boolean _touchOn;
	private boolean _visible = true;
	
	private int _id = -1;
	
	private int _scaleX = FP.ONE, _scaleY = FP.ONE;
	private boolean _scaleFromCentre;
		
	private boolean _requiresPositionUpdate;
	
	private int _touchBorder = 0;

	public void onTouch(int x, int y, MotionEvent event) { }
	public void onTouchDown(int x, int y, MotionEvent event) { }
	public void onTouchMove(int x, int y, MotionEvent event) { }
	public void onTouchUp(int x, int y, MotionEvent event) { }
	public void onTouchExit() { }
	
	public void remove() {
		_dead = true;
	}
	
	public boolean isDead() {
		return _dead;
	}

	protected void makeAlive() {
		_dead = false;
	}
	
	public void setRotationPivot(int rotationPivotX, int rotationPivotY) {
		_rotationPivotX = rotationPivotX;
		_rotationPivotY = rotationPivotY;
		_rotateAboutCentre = false;
	}
	
	public boolean isRotateAboutCentre() {
		return _rotateAboutCentre;
	}
	
	public void setRotationPivotAboutCentre() {
		_rotateAboutCentre = true; 
	}
	
	public void setRotation(int rotationAngle) {
		_rotationAngle = rotationAngle;
		_rotateAboutCentre = false;
	}
	
	public void setRotationAboutCentre(int rotationAngle) {
		_rotationAngle = rotationAngle;
		_rotateAboutCentre = true;
	}
	
	public void rotate(int rotationAngle) {
		_rotationAngle += rotationAngle;
		_rotateAboutCentre = false;
	}
	
	public void rotateAboutCentre(int rotationAngle) {
		_rotationAngle += rotationAngle;
		_rotateAboutCentre = true;
	}
	
	public int getRotationAngle() {
		return _rotationAngle;
	}
	
	public int getRotationPivotX() {
		return _rotationPivotX;
	}
	
	public int getRotationPivotY() {
		return _rotationPivotY;
	}
	
	public void setX(int x) {
		_x = x;
		_requiresPositionUpdate = true;
	}
	
	public void setY(int y) {
		_y = y;
		_requiresPositionUpdate = true;
	}
	
	public void setPos(int x, int y) {
		_x = x;
		_y = y;
		_requiresPositionUpdate = true;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void setWidth(int width) {
		_width = width;
		_requiresPositionUpdate = true;
	}
	
	public void setHeight(int height) {
		_height = height;
		_requiresPositionUpdate = true;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public void setSize(int width, int height) {
		_width = width;
		_height = height;
		_requiresPositionUpdate = true;
	}
	
	public void setVelX(int velX) {
		_velX = velX;
	}
	
	public void setVelY(int velY) {
		_velY = velY;
	}
	
	public int getVelX() {
		return _velX;
	}
	
	public int getVelY() {
		return _velY;
	}
	
	public void setVel(int velX, int velY) {
		_velX = velX;
		_velY = velY;
	}
	
	public void setVelRad(int velocity, int angle) {
		_velY = -FP.mul(velocity, FP.cos(angle));
		_velX = FP.mul(velocity, FP.sin(angle));
	}
	
	public void setAccX(int accX) {
		_accX = accX;
	}
	
	public void setAccY(int accY) {
		_accY = accY;
	}
	
	public int getAccX() {
		return _accX;
	}
	
	public int getAccY() {
		return _accY;
	}
	
	public void setAcc(int accX, int accY) {
		_accX = accX;
		_accY = accY;
	}

	public void setAccRad(int acceleration, int angle) {
		//TODO set acceleration from angle, 0 to 0x10000
	}
	
	public void setAccRad(float acceleration, float angle) {
		//TODO set acceleration from angle, 0 to 1
	}
	
	protected void onDraw(GL10 gl) {

	}
	
	protected void onUpdate() {
		if(_accX != 0)
			_velX += FP.mul(_accX, Rokon.timeModifier);
		if(_velX != 0)
			_x += FP.mul(_velX, Rokon.timeModifier);
		if(_accY != 0)
			_velY += FP.mul(_accY, Rokon.timeModifier);
		if(_velY!= 0)
			_y += FP.mul(_velY, Rokon.timeModifier);
	}
	
	protected boolean requiresPositionUpdate() {
		return _requiresPositionUpdate;
	}	
	
	public void scale(int scaleX, int scaleY) {
		_scaleX = scaleX;
		_scaleY = scaleY;
		_scaleFromCentre = false;
	}
	
	public void scaleFromCentre(int scaleX, int scaleY) {
		_scaleX = scaleX;
		_scaleY = scaleY;
		_scaleFromCentre = true;
	}
	
	public void scaleX(int scaleX) {
		_scaleX = scaleX;
		_scaleFromCentre = false;
	}
	
	public void scaleXFromCentre(int scaleX) {
		_scaleX = scaleX;
		_scaleFromCentre = true;
	}
	
	public void scaleY(int scaleY) {
		_scaleY = scaleY;
		_scaleFromCentre = false;
	}
	
	public void scaleYFromCentre(int scaleY) {
		_scaleY = scaleY;
		_scaleFromCentre = true;
	}
	
	public int getScaleX() {
		return _scaleX;
	}
	
	public int getScaleY() {
		return _scaleY;
	}
	
	public boolean isScaleFromCentre() {
		return _scaleFromCentre;
	}
	
	public void setId(int id) {
		_id = id;
	}

	public int getId() {
		return _id;
	}
	
	public int getTouchBorder() {
		return _touchBorder;
	}
	
	public void setTouchBorder(int border) {
		_touchBorder = border;
	}
	
	protected void setTouchOn() {
		_touchOn = true;
	}
	
	protected void setTouchOff() {
		_touchOn = false;
	}
	
	protected boolean isTouchOn() {
		return _touchOn;
	}
	
	public void setVisible(boolean visible) {
		_visible = visible;
	}
	
	public void show() {
		_visible = true;
	}
	
	public void hide() {
		_visible = false;
	}
	
	public boolean isVisible() {
		return _visible;
	}
	
	
	
}

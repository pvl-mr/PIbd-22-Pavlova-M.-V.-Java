package com.company;

import com.company.Direction;

import java.awt.*;

public interface ITransport {

     void setPosition(int x, int y, int width, int height);
     void moveTransport(Direction direction);
     void drawTransport(Graphics g);

}

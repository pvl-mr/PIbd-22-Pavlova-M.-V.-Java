package com.company;

import java.awt.*;

public interface ITransport {

    public void setPosition(int x, int y, int width, int height);
    public void moveTransport(Direction direction);
    public void drawTransport(Graphics g);


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massspringsystem;

import applicationapi.graphics.Canvas;
import applicationapi.graphics.Color;
import applicationapi.graphics.Sprite;
import applicationapi.graphics.SpriteFactory;
import geometry2d.Point2D;
import util.SpriteUtil;

/**
 *
 * @author tog
 */
public class MassSpringDrawer
{
    private final Sprite ball;
    private final Color black;
    private final Color transparent;
    private final int pixelWidth;
    private final int pixelHeight;
    private final float height;
    private final float width;
    private final SpriteFactory sf;
    private Canvas c;

    public MassSpringDrawer(SpriteFactory sf, int pixelWidth, int pixelHeight, float height, float width)
    {
        this.sf = sf;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.height = height;
        this.width = width;
        this.black = sf.newColor(0, 0, 0, 1);
        this.transparent = sf.newColor(1, 1, 1, 0);
        ball = SpriteUtil.createBall(sf, 10, black, transparent, 10, 10);
    }
    
    public void setCanvas(Canvas c)
    {
        this.c = c;
    }
    
    public void drawSpring(Point2D a, Point2D b)
    {
        c.drawLine(x(a.getX()), y(a.getY()), x(b.getX()), y(b.getY()), black);
    }
    
    public void drawMass(Point2D position)
    {
        c.drawSprite(x(position.getX()), y(position.getY()), ball);
    }
    
    private int x(float x)
    {
        return (int) ((x / width) * pixelWidth); 
    }
    
    private int y(float y)
    {
        return pixelHeight - ((int) ((y / height) * pixelHeight));
    }
}

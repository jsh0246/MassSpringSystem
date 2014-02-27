/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massspringsystem;

import applicationapi.Application;
import applicationapi.Device;
import applicationapi.graphics.Canvas;
import applicationapi.graphics.Screen;
import geometry2d.Point2D;

/**
 *
 * @author tog
 */
public class MassSpringApplication implements Application
{
    private final float width = 120.0f;
    private final float height = 100.0f;
    private MassSpringSystem mss;
    private MassSpringDrawer render;
    private long stateTime;
    
    @Override
    public boolean initialize(Device device)
    {
        stateTime = 0;
        Screen scr = device.getScreen();
        if(scr == null) return false;
        render = new MassSpringDrawer(scr.getSpriteFactory(), scr.getWidth(), scr.getHeight(), width, height);
        mss = new MassSpringSystem();
        PointMass a = mss.createMass(new Point2D(20, 70));
        PointMass b = mss.createMass(new Point2D(60, 70));
        PointMass c = mss.createMass(new Point2D(40, 30));
        mss.createSpring(a, b);
        mss.createSpring(a, c);
        mss.createSpring(b, c);
        //TODO initialize system...
        return true;
    }

    @Override
    public boolean update(long time)
    {
        while(stateTime < time + 10)
        {
            stateTime += 10;
            mss.update(0.1f);
        }
        return true;
    }

    @Override
    public void draw(Canvas canvas)
    {
        render.setCanvas(canvas);
        mss.draw(render);
    }

    @Override
    public void destroy()
    {
        //Do nothing
    }
    
}

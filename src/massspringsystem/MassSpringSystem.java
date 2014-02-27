/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massspringsystem;

import geometry2d.G2D;
import geometry2d.Point2D;
import geometry2d.Vector2D;
import java.util.ArrayList;

/**
 *
 * @author tog
 */
public class MassSpringSystem
{
    private static final float g = 9.82f;
    private ArrayList<PointMass> masses;
    private ArrayList<Spring> springs;

    public MassSpringSystem()
    {
        masses = new ArrayList<>();
        springs = new ArrayList<>();
    }
    
    public PointMass createMass(Point2D pos)
    {
        PointMass pm = new PointMass(pos);
        masses.add(pm);
        return pm;
    }
    
    public void createSpring(PointMass a, PointMass b)
    {
        Spring s = new Spring(a, b);
        springs.add(s);
    }
    
    
    public void update(float dt)
    {
        Vector2D down = new Vector2D(0, -1.0f);
        //Gravity
        for(PointMass m : masses)
        {
            m.addForce(G2D.multiply(down, m.mass()*g));
        }
        
        //Springforces
        for(Spring s : springs)
        {
            s.applyForce();
        }
        
        for(PointMass m : masses)
        {
            m.update(dt);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massspringsystem;

import geometry2d.G2D;
import geometry2d.Point2D;
import geometry2d.Vector2D;

/**
 *
 * @author tog
 */
public class PointMass
{
    private static final float MASS = 1.0f;
    private final float mass;
    private Point2D pos;
    private Vector2D speed;
    private Vector2D forces;

    public PointMass(Point2D pos, float mass)
    {
        this.mass = mass;
        this.pos = pos;
        this.speed = G2D.getZeroVector();
        this.forces = G2D.getZeroVector();
    }
    
    public PointMass(Point2D pos)
    {
        this(pos, MASS);
    }
    
    public void clearForces()
    {
        forces = G2D.getZeroVector();
    }
    
    public void addForce(Vector2D force)
    {
        forces = G2D.add(forces, force);
    }
    
    public void update(float dt)
    {
        Vector2D acc = G2D.multiply(forces, 1.0f/mass);
        speed = G2D.add(speed, G2D.multiply(acc, dt));
        pos = G2D.add(pos, G2D.multiply(speed, dt));
        //Hardcoded floor
        if(pos.getY() < 10.0f)
        {
            pos = new Point2D(pos.getX(), 10);
            speed = new Vector2D(speed.getX(), -speed.getY());
        }
    }
    
    public Point2D getPosition()
    {
        return pos;
    }
    
    public float mass()
    {
        return mass;
    }
}

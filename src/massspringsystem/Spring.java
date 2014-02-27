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
public class Spring
{
    private static final float SPRING_CONSTANT = 10.0f;
    private final PointMass a;
    private final PointMass b;
    private final float idealLength;

    public Spring(PointMass a, PointMass b)
    {
        this.a = a;
        this.b = b;
        this.idealLength = G2D.distance(a.getPosition(), b.getPosition());
    }
    
    
    public void applyForce()
    {
        Vector2D aToB = G2D.fromTo(a.getPosition(), b.getPosition());
        float aToBLength = aToB.length();
        float invLength = 1.0f / aToBLength;
        float d = aToBLength - idealLength;
        float forceA = invLength * SPRING_CONSTANT * d;
        float forceB = -forceA;
        Vector2D fA = G2D.multiply(aToB, forceA);
        Vector2D fB = G2D.multiply(aToB, forceB);
        a.addForce(fA);
        b.addForce(fB);
    }
       
    public Point2D getPosA()
    {
        return a.getPosition();
    }
    
    public Point2D getPosB()
    {
        return b.getPosition();
    }  
}

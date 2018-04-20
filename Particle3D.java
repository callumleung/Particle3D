/**
 * Created by Callum on 27/03/2018.
 */

import java.util.Scanner;

public class Particle3D {
    /**Properties
     */

    private Vector3D position = new Vector3D();
    private Vector3D velocity = new Vector3D();
    private double mass;
    private String label;

    //setters and getters

    /**Get the position of a particle
     *@return a vector that represents the position
     */

    public Vector3D getPosition(){return position;}
    /**Get the velocity
     *@return a vector that gives the 3D velocity
     */
    public Vector3D getVelocity(){return velocity;}
    /**Get the masss
     *@return a double describes the mass
     */
    public double getMass(){return mass;}
    /**Get the name
     *@return a string
     */
    public String getLabel(){return label;}
    /**Set the position of a particle
     *@param p is a vector that describe sthe position of the particle
     */
    public void setPosition(Vector3D p) {this.position=p;}
    /**Set the velocity of the particle
     *@param v is a vector describing the velocity of the particle
     */
    public void setVelocity(Vector3D v) {this.velocity=v;}
    /**Set the mass of the particle
     *@param m is a double representing the mass of the particle
     */
    public void setMass (double m) {this.mass=m;}
    /**Set the name of the particle
     *@param l is a string representing the name of the particle
     */
    public void setLabel(String l){this.label=l;}

    //Constructors

    /**A default constructor is required to indicate that the properties are not initialised
     *The constructor will set all properties to appropriate defaults.
     */
    public Particle3D() {
        this.setPosition(new Vector3D());
        this.setVelocity(new Vector3D());
        this.setMass(Double.NaN);
        this.setLabel(new String());
    }

    /**An explicit constructor is required to construct a new Particle3D with
     *explicitly given position, velocity and mass
     *
     *@param m is a double that defines mass
     *@param p is a vector that defines the position
     *@param v is a vector that defines the velocity
     *@param l is a string tat represents the name of the particle
     */
    public Particle3D(double m, Vector3D p, Vector3D v, String l) {
        this.setMass(m);
        this.setPosition(p);
        this.setVelocity(v);
        this.setLabel(l);
    }


    /**
     * a constructor to create a particle3D object from a file.
     * Useful in the case of many particles, i.e. N-Body simulation.
     * @param filename file from which to read in the data.
     *
     *                 MUST BE OF FORMAT "MASS, Px, Py, Pz, Vx, Vy, Vz"
     *                  All input MUST be in double form.
     *                 Px etc. are the cartesian coords of the particle.
     *                 Vx etc a re the cartesian components of the velocity.
     */

    //TODO ensure some form of verification on the data coming from the file and that the file exists.
    //scan.nextDouble at least ensures that its only taking in doubles but does not go far enough
    public void Particle3D(String filename){

        Scanner scan = new Scanner(filename);
        double mass1 = scan.nextDouble();
        this.setMass(mass1);

        Vector3D P1=new Vector3D();
        P1.setX(scan.nextDouble());
        P1.setY(scan.nextDouble());
        P1.setZ(scan.nextDouble());
        this.setPosition(P1);

        Vector3D V1=new Vector3D();
        V1.setX(scan.nextDouble());
        V1.setY(scan.nextDouble());
        V1.setZ(scan.nextDouble());
        this.setVelocity(V1);
    }


    /**Returns a useful string representation of the Particle3D position
     *this can be used to print a Particle3D instance using the %s
     *format idnetifier
     */
    public String toString(){
        Vector3D pos=getPosition();
        return this.getLabel() + pos.getX() + pos.getY() + pos.getZ() ;
    }



    /**Find the kinetic energy of Particle3D (1/2m*v^2)
     *@return a double that gives the value of the kinetic energy
     */
    public double kineticEnergy() { return 0.5 * mass * Vector3D.dotVector3D(velocity, velocity);}

    /**
     * Returns a vector running from particle A to particle B
     * @param B
     * @return
     */
    public Vector3D relativePosition(Particle3D B){
        return Vector3D.subVector3D(B.getPosition(), this.position);
    }

    /**
     * Similar method to relative positions but with velocities.
     * @param A
     * @param B
     * @return
     */
    public Vector3D relativeVelocity(Particle3D B){

        return Vector3D.subVector3D(B.getVelocity(), this.position);
    }
}

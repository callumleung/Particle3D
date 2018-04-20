/**
 * Created by Callum on 27/03/2018.
 *@author Callum Leung
 *@author Chloe McGeorge
 *
 *
 * A class for a 3 dimensional vector and associated operations.
 *
 *
 *
 */



public class Vector3D {

    private double X;
    private double Y;
    private double Z;

    /**getters to define getX etc.. for use in further code
     */
    public double getX(){return this.X;}
    public double getY(){return this.Y;}
    public double getZ(){return this.Z;}


    /**setters that define setX etc.. for use in further code
     */
    public void setX(double x){this.X = x;}
    public void setY(double y){this.Y = y;}
    public void setZ(double z){this.Z = z;}

    /**default constructor which constructs a new vector with uninitialised x, y, z components
     */

    public Vector3D(){
        this.X = Double.NaN;
        this.Y = Double.NaN;
        this.Z = Double.NaN;
    }

    /**constructor that initialises the vector to (xx,yy,zz)
     */
    public Vector3D(double xx, double yy, double zz){
        this.setX(xx);
        this.setY(yy);
        this.setZ(zz);
    }

    /**magnitude squared and magnitude instance methods that return doubles as per the definition of magnitude
     */
    public double magSquared(){
        return this.getX()*this.getX() + this.getY()*this.getY() + this.getZ()*this.getZ();
    }

    public double mag(){
        return Math.sqrt(this.getX()*this.getX() + this.getY()*this.getY() + this.getZ()*this.getZ());
    }

    /**return a string representation of the vector elements in a useful format the usual (a,b,c) bracket representation used for vectors
     */
    public static String toString(Vector3D vec) {
        return "("+ vec.getX() + "," + vec.getY() + "," + vec.getZ() + ")";
    }

    /**scalar multiply and scalar divide by double instance methods these return vectors as each component is multiplied or divided by a scalar
     */
    public static Vector3D multVector3D (Vector3D a, double b) {
        return new Vector3D(a.getX()*b, a.getY()*b, a.getZ()*b);
    }

    public static Vector3D divideVector3D (Vector3D a, double b) {
        return new Vector3D(a.getX()/b, a.getY()/b, a.getZ()/b);
    }

    /**dot product of two vectors a,b to give a double being the sum of the components multiplied.
     */
    public static Double dotVector3D(Vector3D a, Vector3D b) {
        return (a.getX()*b.getX() + a.getY()*b.getY() + a.getZ()*b.getZ());
    }

    /**calculates the cross product of to vectors a,b to return a vector using the standard definition of a vector cross product for each component.
     */
    public static Vector3D crossVector3D(Vector3D a, Vector3D b){
        return new Vector3D(a.getY()*b.getZ()- b.getY()*a.getZ(),b.getX()*a.getZ()- a.getX()*b.getZ(),a.getX()*b.getY()- b.getX()*a.getY());
    }

    /**component-wise calculation of addition and subtraction of two vectors, returning a vector.
     */
    public static Vector3D addVector3D(Vector3D a, Vector3D b){
        return new Vector3D(a.getX()+ b.getX(), a.getY()+b.getY(),a.getZ()+b.getZ());
    }

    /**
     * Subtracts a vector B from vector A
     * @param a first vector
     * @param b second vector
     * @return
     */
    public static Vector3D subVector3D(Vector3D a,Vector3D b){
        return new Vector3D(a.getX()-b.getX(), a.getY()-b.getY(), a.getZ()- b.getZ());
    }

    /**
     * Equals method, returning true if all three x, y, z components are equal.
     */
    public boolean equals(Vector3D B){
        if (this.X == B.getX() && this.getY() == B.getY() && this.getZ()== B.getZ()){
            return true;
        } else {
            return false;
        }

    }



}







package A_WorkingWithAbstraction.Lab.PointInRectangle;

class Point {
    private int x;
    private int y;

    Point(int... coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    int getX() { return x; }
    void setX(int x) { this.x = x; }
    int getY() { return y; }
    void setY(int y) { this.y = y; }
}

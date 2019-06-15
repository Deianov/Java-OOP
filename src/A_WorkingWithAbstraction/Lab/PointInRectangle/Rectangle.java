package A_WorkingWithAbstraction.Lab.PointInRectangle;

class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    Rectangle(int... coords) {
        this.topLeft = new Point(coords[0], coords[1]);
        this.bottomRight = new Point(coords[2], coords[3]);
    }

    Point getTopLeft() { return topLeft; }
    void setTopLeft(Point topLeft) { this.topLeft = topLeft; }
    Point getBottomRight() { return bottomRight; }
    void setBottomRight(Point bottomRight) { this.bottomRight = bottomRight; }

    boolean contains(Point point) {
        return
                point != null &&
                this.topLeft.getX() <= point.getX() &&
                this.bottomRight.getX() >= point.getX() &&
                this.topLeft.getY() <= point.getY() &&
                this.bottomRight.getY() >= point.getY();
    }
}

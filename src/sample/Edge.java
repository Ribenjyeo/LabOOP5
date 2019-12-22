package sample;

class Edge {

    private String[] point;
    private int backup;

    public Edge(String place1, String place2, int backup){
        this.point = new String[2];
        point[0] = place1;
        point[1] = place2;
        this.backup = backup;
    }

    public String getPoint(){
        for(int i = 0; i < point.length; i++){
            return point[i];
        }
        return null;
    }

    public int getBackup(){
        return backup;
    }

    public void setBackup(int backup){
        this.backup = backup;
    }

    String getPoint1(){
        return point[0];
    }

    String getPoint2(){
        return  point[1];
    }
}

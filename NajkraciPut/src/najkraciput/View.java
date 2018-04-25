package najkraciput;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class View extends JFrame{
    
    private int[][] maze = {{1,1,1,1,1,1},
                            {1,0,0,0,0,1},
                            {1,1,0,1,1,1},
                            {1,0,0,0,0,1},
                            {1,0,1,3,0,1},
                            {1,1,1,1,1,1}}; 
    private List<Integer> path = new ArrayList<Integer>();
    public View(){
        setTitle("Simple Maze Solver");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DepthFirst.searchPath(maze, 3, 1, path);
        System.out.println(path);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.translate(50, 50);
        for(int row=0; row<maze.length; row++){
            for(int col=0; col<maze[0].length; col++){
                Color color;
                switch(maze[row][col]){
                    case 1: color = Color.BLACK;
                    break;
                    case 3: color = Color.RED;
                    break;
                    default: color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30*col,30*row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30*col,30*row, 30, 30);
            }
        }
        for(int p = 0; p<path.size(); p+=2){
            int pathX = path.get(p);
            int pathY = path.get(p+1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX*30, pathY*30, 30, 30);
            
        }
    }

}

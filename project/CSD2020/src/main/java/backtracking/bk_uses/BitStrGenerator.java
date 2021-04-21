/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.bk_uses;

import backtracking.core.BacktrackSolver;
import java.util.ArrayList;
import backtracking.core.RealDomain;
import backtracking.core.IndexDomain;
import backtracking.core.VarSet;
import backtracking.core.Variable;
import backtracking.core.Proposal;
import backtracking.core.DefaultEvaluator;
import backtracking.core.Evaluator;
public class BitStrGenerator {
    public static void main(String[] args) {
        int numOfVars= 4;
        System.out.println("Bit String generator");
        int i;
        RealDomain booleanSet = new RealDomain();
        booleanSet.add(0);
        booleanSet.add(1);
        VarSet varSet = new VarSet();
        for ( i = 0; i < numOfVars; i++) {
            IndexDomain D = new IndexDomain(booleanSet);
            varSet.add(new Variable(D));
            
        }
        DefaultEvaluator evaluator= new DefaultEvaluator();
        BacktrackSolver solver = new  BacktrackSolver(varSet, (Evaluator) evaluator);
        ArrayList<Proposal> solutions;
        System.out.println("get One solution");
        Proposal sol= solver.getOneSolution();
        if (sol!=null)
            System.out.println("A solution:" +sol+ "\n");
        else
            System.out.println("No solution!\n");
        solutions=solver.getAllSolution();
        int n=  solutions.size();
        if(n>0){
            System.out.println("Solution were detected:");
            for ( i = 0; i < n; i++) {
                System.out.println("A solution: "+ solutions.get(i));
                
            }
            
        }else 
                System.out.println("No solutioncan be deleted");
                
    }
    
}

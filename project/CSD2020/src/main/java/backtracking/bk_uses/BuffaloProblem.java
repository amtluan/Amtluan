/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.bk_uses;

import backtracking.core.BacktrackSolver;
import backtracking.core.Evaluator;
import backtracking.core.IndexDomain;
import backtracking.core.Proposal;
import backtracking.core.RealDomain;
import backtracking.core.VarSet;
import backtracking.core.Variable;
import java.util.ArrayList;

/**
 *
 * @author Hứa Minh Luân
 */
public class BuffaloProblem {

    int numOfBuffaloes = 0;
    int numOfWhisks = 0;
    BuffaloEval evaluator;

    class BuffaloEval implements Evaluator {

        private int countGrass(Proposal p) {
            if (p.get(2) % 2 == 1) {
                return 0;
            }
            return p.get(0) * 1 + p.get(1) * 2 + p.get(2) / 2;

        }

        private int countBuffaloes(Proposal p) {
            return p.get(0) + p.get(1) + p.get(2);
        }

        @Override
        public boolean isSaticfied(Proposal p) {
            return countGrass(p) == numOfWhisks && countBuffaloes(p) == numOfBuffaloes;

        }
    }
    public BuffaloProblem(int numOfBuffaloes)
    {
        this.numOfBuffaloes= numOfBuffaloes;
        this.numOfWhisks= this.numOfBuffaloes;
        evaluator= new BuffaloEval();
        
    }
    public BuffaloProblem (int numOfBuffaloes, int noOfWisks){
        this.numOfBuffaloes= numOfBuffaloes;
        this.numOfWhisks= noOfWisks;
        evaluator=new BuffaloEval();
    }
    
    public static void main(String[] args) {
        int numOfGrassPkg=100;
        BuffaloProblem problem = new BuffaloProblem(numOfGrassPkg);
        int minVal=0;
        int maxVal;
        
        RealDomain smallDomain= new RealDomain();
        int val;
        maxVal = numOfGrassPkg;
        if (maxVal>numOfGrassPkg) maxVal= numOfGrassPkg;
        for (val=maxVal; val <=maxVal; val++) smallDomain.add(val);
        RealDomain bigDomain =new RealDomain();
        maxVal = numOfGrassPkg/2;
        if(maxVal> numOfGrassPkg) maxVal = numOfGrassPkg;
        for(val=minVal;val<= maxVal; val++) bigDomain.add(val);
        
        RealDomain oldDomain = new RealDomain();
        maxVal = numOfGrassPkg*2; 
        if(maxVal>numOfGrassPkg) maxVal = numOfGrassPkg;
        for(val=minVal; val<= maxVal; val++) oldDomain.add(val);
        
        VarSet varSet =new VarSet();
        IndexDomain D= new IndexDomain(smallDomain);
        varSet.add(new Variable (D) );
        D= new IndexDomain(bigDomain);
        varSet.add(new Variable(D));
        D= new IndexDomain(oldDomain);
        varSet.add(new Variable(D));
        
        Evaluator evaluator= problem.evaluator;
        
        
        BacktrackSolver solver = new BacktrackSolver(varSet,evaluator);
        ArrayList<Proposal> solutions;
        solutions = solver.getAllSolution();
        
        int n = solutions.size();
        if(solutions.size()>0){
            System.out.println(n+ "solutons were detected: ");
            System.out.println("   [small, big, old detected]");
            for (int i=0; i<n; i++)
                System.out.println("A solution "+ solutions.get(i));
        }
        else System.out.println("No solution can be detected!");
        
        
    }

}

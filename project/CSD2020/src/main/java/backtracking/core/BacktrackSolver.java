/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.core;

import java.util.ArrayList;
public class BacktrackSolver {
    VarSet varSet;
    Evaluator evaluator;
    public BacktrackSolver(VarSet varSet, Evaluator evaluator){
        this.varSet= varSet;
        this.evaluator= evaluator;
        
    }
  private void  getNSolution(int varIndex, int n, ArrayList<Proposal> solutions){
      
      if (solutions.size()== n ) return;
      Variable v= varSet.get(varIndex);
      IndexDomain D= v.getIndexDomain();
      D.reset();
      while(D.hasNext()){
          v.setD_Index(D.nextIndex());
          if(varIndex== varSet.size()-1){
              Proposal prop = new Proposal();
                if (solutions.size()<n) {
              for (Variable var: varSet) prop.add(var.getD_Index());
              if( evaluator.isSaticfied(prop))
                  solutions.add(prop);             
          }
          else return;
      }
      else getNSolution(varIndex+1, n, solutions);
      
  }
  }
  
  public ArrayList<Proposal> getNSolution(int n){
      ArrayList<Proposal> solutions = new ArrayList();
      int varIndex=0;
      getNSolution(varIndex, n, solutions);
      return solutions;
      
  }
  public Proposal getOneSolution(){
      ArrayList<Proposal> solutions;
      solutions= getNSolution(1);
      return solutions.get(0);
      
  }
  
  private  void getAllSolutio(int varIndex, ArrayList<Proposal> solution){
      Variable v= varSet.get(varIndex);
      IndexDomain D= v.getIndexDomain();
      D.reset();
      while(D.hasNext()){
         v.setD_Index(D.nextIndex());
          if(varIndex== varSet.size()-1){
              Proposal prop = new Proposal();
              for (Variable var: varSet) prop.add(var.getD_Index());
              if( evaluator.isSaticfied(prop))
           solution.add(prop);
          }
         else getAllSolutio(+1, solution);
      }
      }
  public ArrayList<Proposal> getAllSolution() {
      ArrayList<Proposal> solutions=new ArrayList();
      int varIndex=0;
      getAllSolutio(varIndex, solutions);
      return solutions;
  }
}



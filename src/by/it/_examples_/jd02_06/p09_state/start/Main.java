package by.it._examples_.jd02_06.p09_state.start;


import by.it._examples_.jd02_06.p09_state.context.TransformerContext;
import by.it._examples_.jd02_06.p09_state.state.FireState;
import by.it._examples_.jd02_06.p09_state.state.MoveState;
import by.it._examples_.jd02_06.p09_state.state.TransformerState;

public class Main {

    public static void main(String[] args) {

        TransformerContext context = new TransformerContext();
        
        TransformerState stateMove = new MoveState();
        TransformerState stateFire = new FireState();

        context.setState(stateFire);
        context.action();

        context.setState(stateMove);
        context.action();
        
    }
}

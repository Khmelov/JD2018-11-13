package by.it._examples_.jd02_06.p09_state.context;


import by.it._examples_.jd02_06.p09_state.state.TransformerState;

public class TransformerContext implements TransformerState {
    
    private TransformerState state;

    public TransformerState getState() {
        return state;
    }

    public void setState(TransformerState state) {
        this.state = state;
    }   

    @Override
    public void action() {
        this.state.action();
    }
   
    
}

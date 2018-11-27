package by.it.zakharenko.jd01_01;

 class Args {
     private String[] args;

     Args(String[] args) {
        this.args=args;
    }

    void printArgs() {
        int i=1;
        for (String arg : args) {
            i=i+1;
            System.out.println("аргумент" + i + "=" + arg);
        }
    }
}

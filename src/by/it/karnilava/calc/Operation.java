package by.it.karnilava.calc;

interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);

}
 // надо сделать в идеале без инстансоф
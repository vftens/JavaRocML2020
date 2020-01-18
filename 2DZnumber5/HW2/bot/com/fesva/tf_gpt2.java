package com.fesva;

import com.simiacryptus.text.TextGenerator;
import com.simiacryptus.text.gpt2.GPT2Util;
//import java.util.function.Predicate;

public class tf_gpt2 {

    static TextGenerator textGenerator = GPT2Util.get345M();

    public tf_gpt2() {
        System.out.println(textGenerator.generateText(500, "Once upon a time"));
    }


    public static void main(String[] args) {

        tf_gpt2 my_tf_gpt2 = new tf_gpt2();

    }
}

package com.jru.mlmsstudent.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MockQuestions {

    public static List<QuizItem> getDummyHtmlQuestions() {

        List<QuizItem> list = new ArrayList<>();

        list.add(new QuizItem(
                "Which of the following is an attribute of the TABLE tag?",
                Arrays.asList(new String[] {
                        "COLOR",
                        "HEIGHT",
                        "BGCOLOR",
                        "SIZE"
                }),
                "c"
        ));

        list.add(new QuizItem(
                "Each list item in an ordered or undered list has which tag?",
                Arrays.asList(new String[] {
                        "li tag",
                        "ol tag",
                        "ls tag",
                        "list tag"
                }),
                "a"
        ));

        list.add(new QuizItem(
                "Which of the following tags is used to automatically center and turns the cell contents into boldface in a table?",
                Arrays.asList(new String[] {
                        "TR",
                        "TD",
                        "TH",
                        "TC"
                }),
                "c"
        ));

        list.add(new QuizItem(
                " HTML source documents are:",
                Arrays.asList(new String[] {
                        "text and graphics",
                        "text and video",
                        "text only",
                        "text and audio"
                }),
                "c"
        ));

        list.add(new QuizItem(
                "To have a heading across rows, the attribute would be__.",
                Arrays.asList(new String[] {
                        "CELLSPACING",
                        "CELLPADDING",
                        "COLSPAN",
                        "ROWSPAN"
                }),
                "d"
        ));

        list.add(new QuizItem(
                "____ defines the space within cells.",
                Arrays.asList(new String[] {
                        "ROWSPAN",
                        "CELLSPACING",
                        "CELLPADDING",
                        "COLSPAN"
                }),
                "b"
        ));

        list.add(new QuizItem(
                "____ is the space between the edge of the cell and the contents.",
                Arrays.asList(new String[] {
                        "ROWSPAN",
                        "COLSPAN",
                        "CELLPADDING",
                        "CELLSPACING"
                }),
                "d"
        ));

        list.add(new QuizItem(
                "The closing tag for background color is___.",
                Arrays.asList(new String[] {
                        "RED",
                        "no closing tag needed",
                        "BGCOLOR",
                        "COLOR"
                }),
                "b"
        ));

        list.add(new QuizItem(
                "In order to begin a new row in a Table you must insert what tag?",
                Arrays.asList(new String[] {
                        "TR",
                        "TH",
                        "NR",
                        "NEW ROW"
                }),
                "a"
        ));

        list.add(new QuizItem(
                "In which tag can you select a background color for your web page?",
                Arrays.asList(new String[] {
                        "TITLE",
                        "HEAD",
                        "BODY",
                        "HTML"
                }),
                "c"
        ));


        return list;

    }

}

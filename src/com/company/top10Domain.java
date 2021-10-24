package com.company;

import java.util.HashMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class top10Domain {

    public static void main(String[] args) {
        //max amount of emails??
        //is all valid?
        String[] input = {
                "sonniymedved@gmail.com",
                "MAKJE@udi.no",
                "gudny.steinsland@skatteetaten.no",
                "Havard.Rolstad@itera.no",
                "anita@merkantilbygg.no",
                "maksym.kochetov@itera.no",
                "honoree@kahoot.com",
                "support@fondy.eu",
                "signy.klempe@gmail.com",
                "anna@hotdevs.com",
                "edson3676@gmail.com",
                "matthew.springham@datarevolutionhr.com",
                "post.oslo@politiet.no",
                "edsonchik@list.ru",
                "support@eyr.md",
                "contact@educative.io",
                "Helene.Langerud@itera.no",
                "andrey.tereshchuk@itera.no",
                "globalassistant2@gmail.com",
                "Elena@manormedicalcenter.com",
                "global2dom@gmail.com",
                "booking@ovingshotellet.no",
                "e.l.engelhart@politiet.no",
                "anatolii.tsaruk@gmail.com",
                "ekostenko@cogniance.com",
                "band1769@hotmail.com",
                "marte.hansen@itera.no",
                "info@manormedicalcenter.com",
                "larisashafieieva@gmail.com",
                "anders.noss@gmail.com"
        };

        String regex = "^(.+)@(.+)$";

        Pattern emailPattern = Pattern.compile("\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
                "\t\t+ \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"");

        String answer = Stream.of(input)
                .filter(not(String::isEmpty))
                .filter(email ->  emailPattern.matcher(email).matches())
                .map(email -> email.substring(email.indexOf("@") + 1))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .map(entry -> String.format("%s %d", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));


        System.out.println(answer);
    }



}

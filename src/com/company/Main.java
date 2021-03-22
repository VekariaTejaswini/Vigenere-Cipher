package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }


    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp_x = y;
            y = x % y;
            x = temp_x;
        }
        return x;
    }

 
    public static double dot(List<Double> a, List<Double> b) {
        double sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

    static String join(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    static List<Double> shift(List<Double> l1, int n1) {
        List<Double> result = new ArrayList<>();
        for (int i = n1; i < l1.size(); i++) {
            result.add(l1.get(i));
        }
        for (int i = 0; i < n1; i++) {
            result.add(l1.get(i));
        }
        return result;
    }

    static void customLogs(List<Integer> N) {
        List<Integer> d = new ArrayList<>(N);
        d.remove(0);
        int L = Collections.max(d);
        System.out.println("Maximum number of coincidence(L):" + L);
        L = d.indexOf(L);
        L += 1;
        ArrayList<Integer> d_no_duplicates = new ArrayList<>(d);
        d_no_duplicates = removeDuplicates(d_no_duplicates);
        List<Integer> d_sorted = new ArrayList<>(d_no_duplicates);
        Collections.sort(d_sorted);
        int L1 = d_sorted.get(d_sorted.size() - 2);
        System.out.println("Second highest number of coincidence(L1):" + L1);
        L1 = d.indexOf(L1);
        L1 += 1;
        int L2 = d_sorted.get(d_sorted.size() - 3);
        System.out.println("Third highest number of coincidence:(L2)" + L2);
        L2 = d.indexOf(L2);
        L2 += 1;
        int L3 = d_sorted.get(d_sorted.size() - 4);
        System.out.println("Fourth highest number of coincidence:(L3)" + L3);
        L3 = d.indexOf(L3);
        L3 += 1;
        int L4 = d_sorted.get(d_sorted.size() - 5);
        System.out.println("Fifth highest number of coincidence(L4):" + L4);
        L4 = d.indexOf(L4);
        L4 += 1;
        int L5 = d_sorted.get(d_sorted.size() - 6);
        System.out.println("Sixth highest number of coincidence:(L5)" + L5);
        L5 = d.indexOf(L5);
        L5 += 1;
        int[] lth = new int[]{L, L1, L2, L3, L4, L5};
        System.out.println("\n" + "Possible key lengths are: " + L + "," + L1 + "," + L2 + "," + L3 + "," + L4 + "," + L5);

        int d1 = gcd(L, L1);
        d1 = gcd(d1, L2);
        d1 = gcd(d1, L3);
        d1 = gcd(d1, L4);
        d1 = gcd(d1, L5);

        System.out.println("gcf of all above shifts:" + d1);
    }

    static Character[] alpha = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static int ceasar(List<Character> text) {
        List<Double> A = new ArrayList<Double>() {{
            add(0.08167);
            add(0.01492);
            add(0.02782);
            add(0.04253);
            add(0.12702);
            add(0.02228);
            add(0.02015);
            add(0.06094);
            add(0.06966);
            add(0.00153);
            add(0.00772);
            add(0.04025);
            add(0.02406);
            add(0.06749);
            add(0.07507);
            add(0.01929);
            add(0.00095);
            add(0.05987);
            add(0.06327);
            add(0.09056);
            add(0.02758);
            add(0.00978);
            add(0.0236);
            add(0.0015);
            add(0.01974);
            add(0.00074);
        }};

        List<List<Double>> Ai = new ArrayList<>();
        for (int y = 0; y < 26; y++) {
            Ai = new ArrayList<>();
        }
        List<Double> W = new ArrayList<>();
        List<Double> prod = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            Ai.add(shift(A, i));
            W.add(((double) Collections.frequency(text, alpha[i])) / text.size());
        }
        for (int i = 0; i < 26; i++) {
            double summation = 0;
            for (int j = 0; j < 25; j++) {
                summation += W.get(j) * Ai.get(i).get(j);
            }
            prod.add(summation);
        }
        int location = prod.indexOf(Collections.max(prod));
        return location;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please enter your vigener cipher text:\n");
            String a_temp = reader.readLine();
            List<Character> text = a_temp.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            List<String> displacement = new ArrayList<>();
            for (int i = 0; i < 31; i++) {
                List<Character> text_temp = new ArrayList<>(text);
                for (int j = 0; j < i; j++) {
                    text_temp.add(text_temp.get(0));
                    text_temp.remove(0);
                }
                displacement.add(join(text_temp));
            }

            List<Integer> N = new ArrayList<>();
            N.add(0);
            for (int i = 1; i < displacement.size(); i++) {
                int sum = 0;
                for (int j = 0; j < text.size(); j++) {
                    if (displacement.get(i).charAt(j) == text.get(j)) {
                        sum += 1;
                    }
                }
                System.out.println("Number of coincidences for " + i + " displacement is: " + sum);
                N.add(sum);
            }
            customLogs(N);

            int largest = Collections.max(N);
            int first = Collections.max(N);
            int second = 0;
            for (int i = 0; i < N.size(); i++) {
                if (N.get(i) > second && !N.get(i).equals(Collections.max(N))) {
                    second = N.get(i);
                }
            }

            int length = gcd(N.indexOf(first), N.indexOf(second));
            List<List<Character>> parts = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                parts.add(new ArrayList<>());
                parts.get(i).add((char) 0);
            }
            int limit = text.size() - text.size() % length;
            for (int i = 0; i < limit; i += length) {
                for (int j = 0; j < length; j++) {
                    parts.get(j).add(text.get(i + j));
                }
            }
            for (int i = limit; i < text.size(); i++) {
                parts.get(i - limit).add(text.get(i));
            }

            List<String> strings = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                strings.add(join(parts.get(i)));
            }
            List<Integer> key = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                List<Character> temp_string = strings.get(i).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
                temp_string.remove(0);
                key.add(ceasar(temp_string));

            }
            List<Character> result = new ArrayList<>();
            List<Character> keyStr = new ArrayList<>();
            boolean encryptionKeyComplete = false;
            for (int i = 0; i < limit; i += length) {
                for (int j = 0; j < length; j++) {
                    int idx = Arrays.asList(alpha).indexOf(text.get(i + j)) + key.get(j) - 26;
                    if (idx < 0) {
                        idx = alpha.length + idx;
                    }
                    result.add(alpha[idx]);
                    if (!encryptionKeyComplete) {
                        int keyCharIndex = (26 - key.get(j)) % 26;
                        keyStr.add(alpha[keyCharIndex]);
                    }
                }
                encryptionKeyComplete = true;
            }
            System.out.println("The Encryption Key:" + join(keyStr));
            for (int i = limit; i < text.size(); i++) {
                int index = Arrays.asList(alpha).indexOf(text.get(i)) + key.get(i - limit) - 26;
                if (index < 0) {
                    index = 26 + index;
                }
                result.add(alpha[index]);
            }
            String final_result = join(result);
            System.out.println("Your plain Text:");
            System.out.println(final_result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;
    
    // Initializes a term with the given query string and weight.
    public Term(String q, long w) {
        query = q;
        weight = w;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                //some condition
                if (v.weight < w.weight) {
                    return 1;
                }
                //some condition
                if (v.weight > w.weight) {
                    return -1;
                }
                //some condition
                return 0;
            }
        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                String v_query = v.query;
                String w_query = w.query;
                for (int i = 0; i < r; i++) {
                    int v_char_weight = (int) v_query.charAt(i);
                    int w_char_weight = (int) w_query.charAt(i);
                    if (v_char_weight != w_char_weight) {
                        return v_char_weight - w_char_weight;
                    }
                }
                // len 2, r 3 : 2
                // len 4, r 3 : 3
                int v_reduced_length = Math.min(v_query.length(), r);
                int w_reduced_length = Math.min(w_query.length(), r);
                return v_reduced_length - w_reduced_length;
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        // StdOut.println("compareTo called");
        String this_query = query;
        String that_query = that.query;
        int min_length = Math.min(this_query.length(), that_query.length());
        for (int i = 0; i < min_length; i++) {
            int this_char_weight = (int) this_query.charAt(i);
            int that_char_weight = (int) that_query.charAt(i);
            if (this_char_weight != that_char_weight) {
                return this_char_weight - that_char_weight;
            }
        }
        return this_query.length() - that_query.length();
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        String s_weight = Long.toString(weight);
        String s_rep = s_weight + "    " + query;
        return s_rep;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        
        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }
}
import java.util.Arrays;

public class Autocomplete {
    
    private Term[] sorted_terms;
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        Arrays.sort(terms);
        sorted_terms = terms;
        
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term searchme = new Term(prefix,0);
        int first_index = BinarySearchDeluxe.firstIndexOf(sorted_terms, searchme, Term.byPrefixOrder(prefix.length()));
        int last_index = BinarySearchDeluxe.lastIndexOf(sorted_terms, searchme, Term.byPrefixOrder(prefix.length()));
        int num_matches = last_index - first_index;
        Term[] results = new Term[num_matches];
        int j = 0;
        for (int i = first_index; i < last_index; i++) {
            results[j] = sorted_terms[i];
            j += 1;

        }
        Arrays.sort(results, Term.byReverseWeightOrder());
        return results;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term searchme = new Term(prefix,0);
        int first_index = BinarySearchDeluxe.firstIndexOf(sorted_terms, searchme, Term.byPrefixOrder(prefix.length()));
        int last_index = BinarySearchDeluxe.lastIndexOf(sorted_terms, searchme, Term.byPrefixOrder(prefix.length()));
        return last_index - first_index;
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
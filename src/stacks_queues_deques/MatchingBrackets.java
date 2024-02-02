package stacks_queues_deques;

public class MatchingBrackets {
    public static boolean isMatched(String expression) {
        String opening = "{([";
        String closing = "})]";
        var buffer = new LinkedStack<Character>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if(buffer.isEmpty()) return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) return false;
            }
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String expression = """
                <body>
                <center>
                <h1> The Little Boat </h1>
                </center>
                <p> The storm tossed the little
                boat like a cheap sneaker in an
                old washing machine. The three
                drunken fishermen were used to
                such treatment, of course, but
                not the tree salesman, who even as
                a stowaway now felt that he
                had overpaid for the voyage. </p>
                <ol>
                <li> Will the salesman die? </li>
                <li> What color is the boat? </li>
                <li> And what about Naomi? </li>
                </ol>
                </body>
                """;
        System.out.println(isMatched(expression));
    }
}

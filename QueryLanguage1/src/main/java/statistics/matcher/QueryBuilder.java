package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And();
    }
    
    public Matcher build() {
        return this.matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(new PlaysIn(team), this.matcher);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(new HasAtLeast(value, category), this.matcher);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(new HasFewerThan(value, category), this.matcher);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }
    
    public QueryBuilder not(Matcher m1) {
        this.matcher = new Not(m1);
        return this;
    }
}

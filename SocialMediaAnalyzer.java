import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class SocialMediaAnalyzer {

    public static void main(String[] args) {
        // Set up Twitter API credentials
        String apiKey = "YOUR_API_KEY";
        String apiSecretKey = "YOUR_API_SECRET_KEY";
        String accessToken = "YOUR_ACCESS_TOKEN";
        String accessTokenSecret = "YOUR_ACCESS_TOKEN_SECRET";

        // Set up Twitter4J configuration
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        // Create a Twitter instance
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        // Search for tweets with a specific hashtag
        String hashtagToSearch = "#Java";
        Query query = new Query(hashtagToSearch);
        try {
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                // Process and analyze tweet data
                System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}

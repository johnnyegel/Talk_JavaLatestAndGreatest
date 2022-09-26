package solutions;

/**
 * Demonstrates using a Text Block
 */
public class Ex07_TextBlocks {

    private static final String LOREM_IPSUM =
            """
            # Lorem Ipsum dolor et al.

            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nibh tellus, pellentesque vitae pretium sed, efficitur
            vitae lacus. Phasellus vulputate sit amet arcu at tincidunt. Morbi vel dignissim lectus, vitae lacinia nunc. Sed vel
            est quis metus egestas viverra in ut enim. Aenean ut ornare nisi, tempus mattis velit. Vivamus placerat ante at aliquet
            placerat. Sed euismod nulla dui. Etiam quis maximus tellus. Nullam id suscipit arcu, at efficitur felis. Maecenas nec
            tellus at velit egestas finibus. Praesent gravida sollicitudin metus. Aenean vehicula sagittis turpis, et placerat mi
            ornare eget. Sed mauris nunc, dapibus nec ligula ac, porttitor porta lectus.

            Integer id quam sodales, aliquet lacus sit amet, posuere orci. Nunc egestas suscipit nibh sed aliquet. Maecenas nisi
            sem, mattis id maximus a, commodo a enim. Fusce volutpat lobortis sagittis. Ut rutrum lectus quis sapien tempor, eget
            luctus quam porta. Fusce blandit dui aliquet lacinia feugiat. Cras justo eros, convallis quis nisi vitae, suscipit
            luctus magna.

            Cras faucibus in risus vel lobortis. Donec finibus nulla a posuere elementum. Duis diam sapien, vestibulum quis mi sed,
            laoreet condimentum justo. Sed ac elit ac dolor molestie sodales et in erat. Maecenas varius quis leo id molestie.
            Etiam ut risus quis turpis porta euismod id at elit. Pellentesque sit amet ipsum ornare, dictum dui sed, feugiat augue.
            Proin sagittis hendrerit sem eget rhoncus. Morbi lobortis vel magna ornare pulvinar. Aenean sagittis porta semper.

            Sed egestas dolor euismod, pulvinar urna at, eleifend ante. Aliquam erat volutpat. Mauris in eros id ante commodo
            egestas. Nam semper luctus neque, id iaculis neque blandit sed. Morbi eget ultrices mi. Praesent fringilla lobortis
            porta. Suspendisse auctor sapien sed mauris lobortis efficitur. Mauris vel pellentesque risus. Pellentesque vel diam
            quis ligula hendrerit lobortis.

            Maecenas suscipit pulvinar nulla non tempor. Quisque a ligula lacus. Cras posuere nulla vitae faucibus porta. Aenean
            consectetur dolor placerat sapien ullamcorper dignissim. Maecenas iaculis urna at nisi lacinia, convallis lacinia urna
            aliquam. Mauris vel massa elit. Nulla rutrum non lorem nec pellentesque. Integer feugiat, quam eget imperdiet fringilla,
            dolor nunc laoreet arcu, in pellentesque leo enim ut lacus. Sed nec mauris aliquam, varius urna quis, sodales ex. Sed
            eget turpis sollicitudin, elementum arcu vitae, viverra odio. Quisque euismod pharetra velit, et scelerisque augue
            fermentum ac. Praesent finibus leo quis arcu semper sollicitudin. Suspendisse nec facilisis elit. Interdum et malesuada
            fames ac ante ipsum primis in faucibus. Ut at diam eu dui finibus feugiat id eu nisl.""";


    /**
     * Runs the demonstration
     * @param args thy giveth ye
     */
    public static void main(String[] args) {
        System.out.println("Example 07: Collectors.teeing() example");

        System.out.println(LOREM_IPSUM);
    }
}

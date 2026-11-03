class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1) {

            return trees;

        }

        Arrays.sort(trees, (a, b) ->

            a[0] == b[0]

                ? Integer.compare(a[1], b[1])

                : Integer.compare(a[0], b[0])

        );

        List<int[]> hull = new ArrayList<>();

        // Lower Hull

        for (int[] p : trees) {

            while (hull.size() >= 2 &&

                cross(

                    hull.get(hull.size() - 2),

                    hull.get(hull.size() - 1),

                    p

                ) < 0) {

                hull.remove(hull.size() - 1);

            }

            hull.add(p);

        }

        int lowerSize = hull.size();

        // Upper Hull

        for (int i = trees.length - 2; i >= 0; i--) {

            int[] p = trees[i];

            while (hull.size() > lowerSize &&

                cross(

                    hull.get(hull.size() - 2),

                    hull.get(hull.size() - 1),

                    p

                ) < 0) {

                hull.remove(hull.size() - 1);

            }

            hull.add(p);

        }

        hull.remove(hull.size() - 1);

        // Remove duplicate coordinates

        Set<Long> seen = new HashSet<>();

        List<int[]> ans = new ArrayList<>();

        for (int[] p : hull) {

            long key = ((long) p[0] << 32) ^ (p[1] & 0xffffffffL);

            if (seen.add(key)) {

                ans.add(p);

            }

        }

        return ans.toArray(new int[ans.size()][]);
    }
    private long cross(int[] A, int[] B, int[] C) {
    return (long)(B[0] - A[0]) * (C[1] - B[1])
    - (long)(B[1] - A[1]) * (C[0] - B[0]);
    }
}
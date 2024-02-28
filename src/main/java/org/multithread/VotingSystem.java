package org.multithread;

import java.util.Scanner;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 候选人信息
        String[] candidates = {"候选人A", "候选人B", "候选人C"};

        // 记录每个候选人的得票数
        int[] votes = new int[candidates.length];

        System.out.println("投票开始，请输入候选人编号进行投票（输入 0 结束投票）：");
        while (true) {
            // 展示候选人信息
            for (int i = 0; i < candidates.length; i++) {
                System.out.println((i + 1) + ". " + candidates[i]);
            }

            System.out.print("请输入候选人编号进行投票（输入 0 结束投票）：");
            int vote = scanner.nextInt();

            if (vote == 0) {
                break;
            }

            if (vote >= 1 && vote <= candidates.length) {
                votes[vote - 1]++;
                System.out.println("您投给了 " + candidates[vote - 1]);
            } else {
                System.out.println("无效的候选人编号，请重新投票！");
            }
        }

        // 找出得票最高的候选人
        int maxVotes = votes[0];
        int maxIndex = 0;
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                maxIndex = i;
            }
        }

        // 输出投票结果
        System.out.println("投票结束，得票情况如下：");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i] + ": " + votes[i] + " 票");
        }
        System.out.println("得票最高的候选人是：" + candidates[maxIndex] + "，共获得 " + maxVotes + " 票");
    }
}



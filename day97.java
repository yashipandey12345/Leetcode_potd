import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long totalSkill = 0;
        
        // Calculate total skill
        for (int s : skill) {
            totalSkill += s;
        }
        
        // Check if total skill is even
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }
        
        long targetTeamSkill = totalSkill / (n / 2);
        
        // Sort the skill array
        Arrays.sort(skill);
        
        long chemistrySum = 0;
        
        // Form teams from ends of the sorted array
        for (int i = 0; i < n / 2; i++) {
            long teamSkill = skill[i] + skill[n - 1 - i];
            // Check if team skill matches target team skill
            if (teamSkill != targetTeamSkill) {
                return -1;
            }
            // Calculate chemistry
            chemistrySum += (long) skill[i] * skill[n - 1 - i];
        }
        
        return chemistrySum;
    }
}


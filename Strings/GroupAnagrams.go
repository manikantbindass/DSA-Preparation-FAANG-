// LeetCode 49 - Group Anagrams
// Time Complexity: O(n * k log k) | Space Complexity: O(n * k)
package main

import (
	"sort"
)

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)

	for _, s := range strs {
		chars := []byte(s)
		sort.Slice(chars, func(i, j int) bool {
			return chars[i] < chars[j]
		})
		key := string(chars)
		groups[key] = append(groups[key], s)
	}

	answer := make([][]string, 0, len(groups))
	for _, group := range groups {
		answer = append(answer, group)
	}

	return answer
}

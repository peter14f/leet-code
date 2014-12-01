def justify(string, word_cnt, word_list, L):
    space_cnt = []
    string_length = len(string)

    for i in range(len(word_list) - 1):
        space_cnt.append(1)
    
    if len(space_cnt) > 0:
        while string_length < L:
        
            for j in range(len(space_cnt)):
                space_cnt[j] += 1
                string_length += 1
                
                if string_length == L:
                    ans = ""
                    for word_index in range(len(word_list)):
                        ans += word_list[word_index]
                        if word_index < len(word_list) - 1:
                            for j in range(space_cnt[word_index]):
                                ans += ' '
                    return ans
    else:
        while string_length < L:
            string += ' '
            string_length += 1
        return string

class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
        ans = []
        word_list = []
        word_cnt = 0
        
        for word in words:

            if len(ans) == 0 or len(ans[len(ans) - 1]) == L:
                # first word or previous row already justified 
                ans.append(word) # append to ans, the last element of ans is current row
                word_list = [word]
                word_cnt = 1
            else:
               cur_row_string = ans.pop()
               
               if len(cur_row_string) + 1 + len(word) < L:
                   ans.append(cur_row_string + " " + word)
                   word_list.append(word)
                   word_cnt += 1
               elif len(cur_row_string) + 1 + len(word) == L:
                   ans.append(cur_row_string + " " + word)
                   word_cnt = 0
                   word_list = []
               else:
                   justified_string = justify(cur_row_string, word_cnt, word_list, L)
                   ans.append(justified_string)
                   ans.append(word)
                   word_list = [word]
                   word_cnt = 1
        
        last_row_length = len(ans[len(ans) - 1])
        
        if last_row_length < L:
            last_row_string = ans.pop()
            while last_row_length < L:
                last_row_string += ' '
                last_row_length += 1
            ans.append(last_row_string)
        return ans


l = ["This", "is", "an", "example", "of", "text", "justification."]
L = 16

s = Solution()
ans = s.fullJustify(l, L)
print ans

l = ["Listen","to","many,","speak","to","a","few."]
L = 6

ans = s.fullJustify(l, L)
print ans

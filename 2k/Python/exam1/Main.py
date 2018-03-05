import urllib.request
import re
import json

class Object:
    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, sort_keys=True, indent=4)

class Tree(Object):
    def __init__(self, N):
        self.children = []
        self.N = N

def make_rfc_tree(k, m, N, cur_tree):
    local_filename, headers = urllib.request.urlretrieve('https://www.rfc-editor.org/rfc/rfc%d.txt' % N)
    html = open(local_filename)
    if m == 0:
        return

    for i in range(k):
        line = html.readline()
        match = re.findall(r"RFC\d{1,4}|\[RFC\d{1,4}\]", line)
        if match:
            for mim in match:
                rfc_match = re.search("\d{1,4}", mim)
                cur_tree_children = cur_tree.children

                for child in cur_tree_children:
                    if child.N == rfc_match.group():
                        return

                if rfc_match.group() != str(N):
                    print(rfc_match.group())
                    new_tree = Tree(rfc_match.group())
                    cur_tree_children.append(new_tree)
                    make_rfc_tree(k, m - 1, int(rfc_match.group()), new_tree)

if __name__ == '__main__':
    tree = Tree(8031)
    make_rfc_tree(100, 2, 8031, tree)
    s = tree.toJSON()
    print(s)
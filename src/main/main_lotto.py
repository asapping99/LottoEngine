import os
import sys

# Ensure project root is on the Python path so that util modules can be found
PROJECT_ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
if PROJECT_ROOT not in sys.path:
    sys.path.insert(0, PROJECT_ROOT)

from util.xml.xml_parse import XMLParse


class MainLotto:
    def initialize(self):
        XMLParse.execute()

    def execute(self):
        self.initialize()

    def run(self):
        pass


def main():
    lotto = MainLotto()
    lotto.execute()


if __name__ == "__main__":
    main()

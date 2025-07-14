import os
import xml.etree.ElementTree as ET
from typing import Dict

from .xml_constant import XMLConstant


class XMLParse:
    """Parse XML configuration files from the config directory."""
    xml_file_path = "config"
    xml_parse_map: Dict[str, Dict[str, str]] = {}

    @classmethod
    def execute(cls) -> None:
        try:
            cls._dom_parse()
        except Exception as e:
            print(e)

    @classmethod
    def _dom_parse(cls) -> None:
        for filename in os.listdir(cls.xml_file_path):
            filepath = os.path.join(cls.xml_file_path, filename)
            if not filepath.lower().endswith(".xml"):
                continue
            doc = ET.parse(filepath)
            root = doc.getroot()
            cls._put_parse_map_by_xml(root)

    @classmethod
    def _put_parse_map_by_xml(cls, root: ET.Element) -> None:
        for name in dir(XMLConstant):
            if name.isupper():
                value = getattr(XMLConstant, name)
                prefix = f"{XMLConstant.PREFIX_TAG}_"
                if not value.startswith(prefix):
                    for elem in root.findall(value):
                        cls.xml_parse_map[elem.tag] = elem.attrib

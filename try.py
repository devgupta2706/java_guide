import docx
 
 
def main():
    try:
        doc = docx.Document('test.docx')  # Creating word reader object.
        data = ""
        fullText = []
        for para in doc.paragraphs:
            fullText.append(para.text)
            data = '\n'.join(fullText)
 
        print(data)
 
    except IOError:
        print('There was an error opening the file!')
        return
 
 
if __name__ == '__main__':
    main()
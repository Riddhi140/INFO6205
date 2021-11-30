# Import the required Module
import tabula
# Read a PDF File
df = tabula.read_pdf("RamayanHindi.pdf", pages='all')[0]
# convert PDF into CSV
tabula.convert_into("RamayanHindi.pdf", "RamayanHindi.csv", output_format="csv", pages='all')
print(df)
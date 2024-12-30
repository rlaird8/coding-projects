import sqlite3
import hashlib
from cryptography.fernet import Fernet

# Load the previously generated encryption key
key = b'pD0b1W1vinjb1LK_H5Uk7WoQipbUhgi7jpkqwFWSDAw='
cipher = Fernet(key)

# Connect to your SQLite database
conn = sqlite3.connect('ryanDB.db')
cursor = conn.cursor()

# Create a new table to store encrypted data with blockchain linkage
#this table will be used for demonstration and output
cursor.execute('''CREATE TABLE IF NOT EXISTS BlockchainTable 
                  (ID INTEGER PRIMARY KEY AUTOINCREMENT, 
                   EncryptedData BLOB, 
                   CurrentHash TEXT, 
                   PreviousHash TEXT)''')

# Example rows of data from another table (e.g., Events)
cursor.execute("SELECT * FROM Events")
rows = cursor.fetchall()

previous_hash = "0"  # Initialize the previous hash for the first row

# Insert encrypted data and hashes into the blockchain table
for row in rows:
    row_data = str(row).encode()  # Convert the row data to bytes

    # Encrypt the row data
    encrypted_row_data = cipher.encrypt(row_data)

    # Compute the current hash (encrypted data + previous hash)
    hash_input = encrypted_row_data + previous_hash.encode()
    current_hash = hashlib.sha256(hash_input).hexdigest()

    # Insert the encrypted data, current hash, and previous hash into the table
    cursor.execute("INSERT INTO BlockchainTable (EncryptedData, CurrentHash, PreviousHash) VALUES (?, ?, ?)",
                   (encrypted_row_data, current_hash, previous_hash))

    # Update the previous hash for the next row
    previous_hash = current_hash

# Commit and close the connection
conn.commit()
conn.close()

print("Blockchain table has been created and populated.")

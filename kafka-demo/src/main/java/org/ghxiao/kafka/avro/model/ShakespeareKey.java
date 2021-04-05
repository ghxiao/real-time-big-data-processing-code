/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.ghxiao.kafka.avro.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ShakespeareKey extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7489577363918428893L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ShakespeareKey\",\"namespace\":\"org.ghxiao.kafka.avro.model\",\"fields\":[{\"name\":\"work\",\"type\":\"string\",\"doc\":\"The name of the work\"},{\"name\":\"year\",\"type\":\"int\",\"doc\":\"The year the work was published\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ShakespeareKey> ENCODER =
      new BinaryMessageEncoder<ShakespeareKey>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ShakespeareKey> DECODER =
      new BinaryMessageDecoder<ShakespeareKey>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ShakespeareKey> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ShakespeareKey> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ShakespeareKey>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ShakespeareKey to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ShakespeareKey from a ByteBuffer. */
  public static ShakespeareKey fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The name of the work */
  @Deprecated public java.lang.CharSequence work;
  /** The year the work was published */
  @Deprecated public int year;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ShakespeareKey() {}

  /**
   * All-args constructor.
   * @param work The name of the work
   * @param year The year the work was published
   */
  public ShakespeareKey(java.lang.CharSequence work, java.lang.Integer year) {
    this.work = work;
    this.year = year;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return work;
    case 1: return year;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: work = (java.lang.CharSequence)value$; break;
    case 1: year = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'work' field.
   * @return The name of the work
   */
  public java.lang.CharSequence getWork() {
    return work;
  }

  /**
   * Sets the value of the 'work' field.
   * The name of the work
   * @param value the value to set.
   */
  public void setWork(java.lang.CharSequence value) {
    this.work = value;
  }

  /**
   * Gets the value of the 'year' field.
   * @return The year the work was published
   */
  public java.lang.Integer getYear() {
    return year;
  }

  /**
   * Sets the value of the 'year' field.
   * The year the work was published
   * @param value the value to set.
   */
  public void setYear(java.lang.Integer value) {
    this.year = value;
  }

  /**
   * Creates a new ShakespeareKey RecordBuilder.
   * @return A new ShakespeareKey RecordBuilder
   */
  public static org.ghxiao.kafka.avro.model.ShakespeareKey.Builder newBuilder() {
    return new org.ghxiao.kafka.avro.model.ShakespeareKey.Builder();
  }

  /**
   * Creates a new ShakespeareKey RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ShakespeareKey RecordBuilder
   */
  public static org.ghxiao.kafka.avro.model.ShakespeareKey.Builder newBuilder(org.ghxiao.kafka.avro.model.ShakespeareKey.Builder other) {
    return new org.ghxiao.kafka.avro.model.ShakespeareKey.Builder(other);
  }

  /**
   * Creates a new ShakespeareKey RecordBuilder by copying an existing ShakespeareKey instance.
   * @param other The existing instance to copy.
   * @return A new ShakespeareKey RecordBuilder
   */
  public static org.ghxiao.kafka.avro.model.ShakespeareKey.Builder newBuilder(org.ghxiao.kafka.avro.model.ShakespeareKey other) {
    return new org.ghxiao.kafka.avro.model.ShakespeareKey.Builder(other);
  }

  /**
   * RecordBuilder for ShakespeareKey instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ShakespeareKey>
    implements org.apache.avro.data.RecordBuilder<ShakespeareKey> {

    /** The name of the work */
    private java.lang.CharSequence work;
    /** The year the work was published */
    private int year;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.ghxiao.kafka.avro.model.ShakespeareKey.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.work)) {
        this.work = data().deepCopy(fields()[0].schema(), other.work);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.year)) {
        this.year = data().deepCopy(fields()[1].schema(), other.year);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ShakespeareKey instance
     * @param other The existing instance to copy.
     */
    private Builder(org.ghxiao.kafka.avro.model.ShakespeareKey other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.work)) {
        this.work = data().deepCopy(fields()[0].schema(), other.work);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.year)) {
        this.year = data().deepCopy(fields()[1].schema(), other.year);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'work' field.
      * The name of the work
      * @return The value.
      */
    public java.lang.CharSequence getWork() {
      return work;
    }

    /**
      * Sets the value of the 'work' field.
      * The name of the work
      * @param value The value of 'work'.
      * @return This builder.
      */
    public org.ghxiao.kafka.avro.model.ShakespeareKey.Builder setWork(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.work = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'work' field has been set.
      * The name of the work
      * @return True if the 'work' field has been set, false otherwise.
      */
    public boolean hasWork() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'work' field.
      * The name of the work
      * @return This builder.
      */
    public org.ghxiao.kafka.avro.model.ShakespeareKey.Builder clearWork() {
      work = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'year' field.
      * The year the work was published
      * @return The value.
      */
    public java.lang.Integer getYear() {
      return year;
    }

    /**
      * Sets the value of the 'year' field.
      * The year the work was published
      * @param value The value of 'year'.
      * @return This builder.
      */
    public org.ghxiao.kafka.avro.model.ShakespeareKey.Builder setYear(int value) {
      validate(fields()[1], value);
      this.year = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'year' field has been set.
      * The year the work was published
      * @return True if the 'year' field has been set, false otherwise.
      */
    public boolean hasYear() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'year' field.
      * The year the work was published
      * @return This builder.
      */
    public org.ghxiao.kafka.avro.model.ShakespeareKey.Builder clearYear() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ShakespeareKey build() {
      try {
        ShakespeareKey record = new ShakespeareKey();
        record.work = fieldSetFlags()[0] ? this.work : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.year = fieldSetFlags()[1] ? this.year : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ShakespeareKey>
    WRITER$ = (org.apache.avro.io.DatumWriter<ShakespeareKey>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ShakespeareKey>
    READER$ = (org.apache.avro.io.DatumReader<ShakespeareKey>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}

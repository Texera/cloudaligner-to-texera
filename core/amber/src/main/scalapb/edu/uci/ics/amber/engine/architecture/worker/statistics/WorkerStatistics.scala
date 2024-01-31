// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package edu.uci.ics.amber.engine.architecture.worker.statistics

@SerialVersionUID(0L)
final case class WorkerStatistics(
    workerState: edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState,
    inputTupleCount: _root_.scala.Long,
    outputTupleCount: _root_.scala.Long,
    dataProcessingTime: _root_.scala.Long,
    controlProcessingTime: _root_.scala.Long,
    idleTime: _root_.scala.Long
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[WorkerStatistics] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = workerState.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(1, __value)
        }
      };
      
      {
        val __value = inputTupleCount
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(2, __value)
        }
      };
      
      {
        val __value = outputTupleCount
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
        }
      };
      
      {
        val __value = dataProcessingTime
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(4, __value)
        }
      };
      
      {
        val __value = controlProcessingTime
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(5, __value)
        }
      };
      
      {
        val __value = idleTime
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(6, __value)
        }
      };
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = workerState.value
        if (__v != 0) {
          _output__.writeEnum(1, __v)
        }
      };
      {
        val __v = inputTupleCount
        if (__v != 0L) {
          _output__.writeInt64(2, __v)
        }
      };
      {
        val __v = outputTupleCount
        if (__v != 0L) {
          _output__.writeInt64(3, __v)
        }
      };
      {
        val __v = dataProcessingTime
        if (__v != 0L) {
          _output__.writeInt64(4, __v)
        }
      };
      {
        val __v = controlProcessingTime
        if (__v != 0L) {
          _output__.writeInt64(5, __v)
        }
      };
      {
        val __v = idleTime
        if (__v != 0L) {
          _output__.writeInt64(6, __v)
        }
      };
    }
    def withWorkerState(__v: edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState): WorkerStatistics = copy(workerState = __v)
    def withInputTupleCount(__v: _root_.scala.Long): WorkerStatistics = copy(inputTupleCount = __v)
    def withOutputTupleCount(__v: _root_.scala.Long): WorkerStatistics = copy(outputTupleCount = __v)
    def withDataProcessingTime(__v: _root_.scala.Long): WorkerStatistics = copy(dataProcessingTime = __v)
    def withControlProcessingTime(__v: _root_.scala.Long): WorkerStatistics = copy(controlProcessingTime = __v)
    def withIdleTime(__v: _root_.scala.Long): WorkerStatistics = copy(idleTime = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = workerState.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
        case 2 => {
          val __t = inputTupleCount
          if (__t != 0L) __t else null
        }
        case 3 => {
          val __t = outputTupleCount
          if (__t != 0L) __t else null
        }
        case 4 => {
          val __t = dataProcessingTime
          if (__t != 0L) __t else null
        }
        case 5 => {
          val __t = controlProcessingTime
          if (__t != 0L) __t else null
        }
        case 6 => {
          val __t = idleTime
          if (__t != 0L) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PEnum(workerState.scalaValueDescriptor)
        case 2 => _root_.scalapb.descriptors.PLong(inputTupleCount)
        case 3 => _root_.scalapb.descriptors.PLong(outputTupleCount)
        case 4 => _root_.scalapb.descriptors.PLong(dataProcessingTime)
        case 5 => _root_.scalapb.descriptors.PLong(controlProcessingTime)
        case 6 => _root_.scalapb.descriptors.PLong(idleTime)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToSingleLineUnicodeString(this)
    def companion = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics
    // @@protoc_insertion_point(GeneratedMessage[edu.uci.ics.amber.engine.architecture.worker.WorkerStatistics])
}

object WorkerStatistics extends scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics = {
    var __workerState: edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState.UNINITIALIZED
    var __inputTupleCount: _root_.scala.Long = 0L
    var __outputTupleCount: _root_.scala.Long = 0L
    var __dataProcessingTime: _root_.scala.Long = 0L
    var __controlProcessingTime: _root_.scala.Long = 0L
    var __idleTime: _root_.scala.Long = 0L
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __workerState = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState.fromValue(_input__.readEnum())
        case 16 =>
          __inputTupleCount = _input__.readInt64()
        case 24 =>
          __outputTupleCount = _input__.readInt64()
        case 32 =>
          __dataProcessingTime = _input__.readInt64()
        case 40 =>
          __controlProcessingTime = _input__.readInt64()
        case 48 =>
          __idleTime = _input__.readInt64()
        case tag => _input__.skipField(tag)
      }
    }
    edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics(
        workerState = __workerState,
        inputTupleCount = __inputTupleCount,
        outputTupleCount = __outputTupleCount,
        dataProcessingTime = __dataProcessingTime,
        controlProcessingTime = __controlProcessingTime,
        idleTime = __idleTime
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics(
        workerState = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState.UNINITIALIZED.scalaValueDescriptor).number),
        inputTupleCount = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        outputTupleCount = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        dataProcessingTime = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        controlProcessingTime = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        idleTime = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = StatisticsProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = StatisticsProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 1 => edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState
    }
  }
  lazy val defaultInstance = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics(
    workerState = edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState.UNINITIALIZED,
    inputTupleCount = 0L,
    outputTupleCount = 0L,
    dataProcessingTime = 0L,
    controlProcessingTime = 0L,
    idleTime = 0L
  )
  implicit class WorkerStatisticsLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics](_l) {
    def workerState: _root_.scalapb.lenses.Lens[UpperPB, edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState] = field(_.workerState)((c_, f_) => c_.copy(workerState = f_))
    def inputTupleCount: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.inputTupleCount)((c_, f_) => c_.copy(inputTupleCount = f_))
    def outputTupleCount: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.outputTupleCount)((c_, f_) => c_.copy(outputTupleCount = f_))
    def dataProcessingTime: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.dataProcessingTime)((c_, f_) => c_.copy(dataProcessingTime = f_))
    def controlProcessingTime: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.controlProcessingTime)((c_, f_) => c_.copy(controlProcessingTime = f_))
    def idleTime: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.idleTime)((c_, f_) => c_.copy(idleTime = f_))
  }
  final val WORKER_STATE_FIELD_NUMBER = 1
  final val INPUT_TUPLE_COUNT_FIELD_NUMBER = 2
  final val OUTPUT_TUPLE_COUNT_FIELD_NUMBER = 3
  final val DATA_PROCESSING_TIME_FIELD_NUMBER = 4
  final val CONTROL_PROCESSING_TIME_FIELD_NUMBER = 5
  final val IDLE_TIME_FIELD_NUMBER = 6
  def of(
    workerState: edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerState,
    inputTupleCount: _root_.scala.Long,
    outputTupleCount: _root_.scala.Long,
    dataProcessingTime: _root_.scala.Long,
    controlProcessingTime: _root_.scala.Long,
    idleTime: _root_.scala.Long
  ): _root_.edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics = _root_.edu.uci.ics.amber.engine.architecture.worker.statistics.WorkerStatistics(
    workerState,
    inputTupleCount,
    outputTupleCount,
    dataProcessingTime,
    controlProcessingTime,
    idleTime
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[edu.uci.ics.amber.engine.architecture.worker.WorkerStatistics])
}

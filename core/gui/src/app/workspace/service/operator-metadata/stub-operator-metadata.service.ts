import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { mockOperatorMetaData } from "./mock-operator-metadata.data";
import { OperatorMetadata, OperatorSchema } from "../../types/operator-schema.interface";
import { IOperatorMetadataService } from "./operator-metadata.service";
import { shareReplay } from "rxjs/operators";

@Injectable()
export class StubOperatorMetadataService implements IOperatorMetadataService {
  private operatorMetadataObservable = of(mockOperatorMetaData).pipe(shareReplay(1));

  public getOperatorSchema(operatorType: string): OperatorSchema {
    const operatorSchema = mockOperatorMetaData.operators.find(schema => schema.operatorType === operatorType);
    if (!operatorSchema) {
      throw new Error(`can\'t find operator schema of type ${operatorType}`);
    }
    return operatorSchema;
  }

  public getOperatorMetadata(): Observable<OperatorMetadata> {
    return this.operatorMetadataObservable;
  }

  public operatorTypeExists(operatorType: string): boolean {
    const operator = mockOperatorMetaData.operators.filter(op => op.operatorType === operatorType);
    if (operator.length === 0) {
      return false;
    }
    return true;
  }
}
